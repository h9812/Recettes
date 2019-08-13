package com.d2h2.recettes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.Task;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private CallbackManager callbackManager;
    private LoginButton fb_login;
    private SignInButton gg_login;
//    private static final int MY_NOTIFICATION_ID = 12345;
//    private static final int MY_REQUEST_CODE = 100;
    private String name, email, url_avatar, id;
    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 001;
    public final String SHARED_PREFERENCES_NAME = "User";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initActions();
    }

    private void initView() {
        fb_login = findViewById(R.id.fb_login);
        gg_login = findViewById(R.id.gg_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    private void initActions() {
        gg_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
        callbackManager = CallbackManager.Factory.create();
        fb_login.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                loadUserProfile(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException error) {
            }
        });

    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    //lay ket qua fb,gg
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        } else callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void loadUserProfile(AccessToken newAccessToken) {
        GraphRequest request = GraphRequest.newMeRequest(
                newAccessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object,
                                            GraphResponse response) {
                        name = object.optString("name");
                        id = object.optString("id");
                        if (object.optString("email").equals(""))
                            email = id + "@facebook.com";
                        else
                            email = object.optString("email");
                        url_avatar = "https://graph.facebook.com/" + id + "/picture?type=large";
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email", email);
                        editor.putString("name", name);
                        editor.putString("url", url_avatar);
                        editor.apply();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        LoginActivity.this.startActivity(intent);
                        finish();

                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email");
        request.setParameters(parameters);
        request.executeAsync();

    }


    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        if (completedTask.isSuccessful()) {

            GoogleSignInAccount acct = completedTask.getResult();
            name = acct.getDisplayName();
            email = acct.getEmail();
            url_avatar = acct.getPhotoUrl() != null ? acct.getPhotoUrl().toString() : "";
            if (url_avatar == "") {
                url_avatar = "https://cdn.pixabay.com/photo/2016/11/14/17/39/person-1824144_960_720.png?fbclid=IwAR2q20Tc1tDUNh3N860J37uXH55VJmHKEAj_S8cFIuFcVbHMgQx9NKVTb_o";
            }
            Log.d("@@@@@", email);
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("email", email);
            editor.putString("name", name);
            editor.putString("url", url_avatar);
            editor.apply();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            LoginActivity.this.startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        finish();
    }
}
