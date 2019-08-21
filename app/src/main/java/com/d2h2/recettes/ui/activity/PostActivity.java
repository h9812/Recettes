package com.d2h2.recettes.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.d2h2.recettes.R;
import com.d2h2.recettes.data.Repository;
import com.d2h2.recettes.data.model.User;
import com.d2h2.recettes.util.AppUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.facebook.share.internal.DeviceShareDialogFragment.TAG;

public class PostActivity extends AppCompatActivity {
    private CompositeDisposable compositeDisposable;
    private Repository repository = AppUtil.getRepository();
    private ImageView mImgAvatar;
    private TextView mTxtName;
    private TextView mTxtGenre;
    private TextView mTxtTest;
    private Button mBtnPost;
    private ImageView mImgBack;
    private EditText mEdtPostName;
    private EditText mEdtPostDescription;
    private EditText mEdtStep1;
    private EditText mEdtStep2;
    private EditText mEdtStep3;
    private List<String> mStep = new ArrayList<>();
    private final View.OnClickListener mImgAvatarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            FragmentProfile fragmentProfile = new FragmentProfile();
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragmentProfile).commit();
        }
    };
    private final View.OnClickListener mImgBackClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           finish();
        }
    };
    private final View.OnClickListener mBtnPostClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            sendPost();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        initView();
        initActions();
    }

    private void initView() {
        mImgAvatar = findViewById(R.id.img_avatar);
        mTxtName = findViewById(R.id.txt_name);
        mTxtGenre = findViewById(R.id.txt_genre);
        mBtnPost = findViewById(R.id.btn_post);
        mImgBack = findViewById(R.id.img_back);
        mEdtPostName = findViewById(R.id.edt_post_name);
        mEdtPostDescription = findViewById(R.id.edt_post_description);
        mEdtStep1 = findViewById(R.id.edt_step1);
        mEdtStep2 = findViewById(R.id.edt_step2);
        mEdtStep3 = findViewById(R.id.edt_step3);
    }

    @SuppressLint("NewApi")
    private void initActions() {
        User user = new User(this);
        mTxtName.setText(user.getName());
        Glide.with(Objects.requireNonNull(this))
                .load(user.getUrl_avatar())
                .into(mImgAvatar);
        mImgAvatar.setOnClickListener(mImgAvatarClickListener);
        mImgBack.setOnClickListener(mImgBackClickListener);
        mBtnPost.setOnClickListener(mBtnPostClickListener);
    }
    @SuppressLint("LongLogTag")
    private void sendPost(){
        User user = new User(this);
        String postName = mEdtPostName.getText().toString();
        String postDescription = mEdtPostDescription.getText().toString();
        String step1 = mEdtStep1.getText().toString();
        String step2 = mEdtStep2.getText().toString();
        String step3 = mEdtStep3.getText().toString();


        if(!step1.equals("")) mStep.add(0,step1);
        if(!step2.equals("")) mStep.add(0,step2);
        if(!step3.equals("")) mStep.add(0,step3);
        if(postName.equals("")){
            Toast.makeText(this, "Vui lòng nhập món ăn", Toast.LENGTH_SHORT).show();
        }
        else{
            repository.postRecipes(postName, postDescription, mStep ,user.getId())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(commentRepo -> {
//                                Log.d(TAG, "sendPost: " + commentRepo.getComment().getContent());
                                Intent intent = new Intent(this, MainActivity.class);
                                startActivity(intent);
                            },
                            throwable -> {
                                Log.d(TAG, "sendPost: " + throwable.getMessage() );
                            });
        }
    }
}
