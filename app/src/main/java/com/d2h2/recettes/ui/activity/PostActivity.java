package com.d2h2.recettes.ui.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.d2h2.recettes.R;
import com.d2h2.recettes.data.Repo.ImgRepo;
import com.d2h2.recettes.data.Repository;
import com.d2h2.recettes.data.model.User;
import com.d2h2.recettes.ui.adapter.AddImageAdapter;
import com.d2h2.recettes.ui.adapter.RealPathUtil;
import com.d2h2.recettes.util.AppUtil;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.facebook.share.internal.DeviceShareDialogFragment.TAG;

public class PostActivity extends AppCompatActivity {
    private ArrayList<String> imgName, imgCode ;
    String postName;
    String postDescription;
    private CompositeDisposable compositeDisposable;
    private Repository repository = AppUtil.getRepository();
    private int REQUEST_GALLERY_IMAGE = 100;
    private ImageView mImgAvatar;
    private ImageView mPickImg;
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
    private List<String> mListImg = new ArrayList<>();
    private RecyclerView mRvListImg;
    private ArrayList<Uri> uri = new ArrayList<>();
    private String mListPickImg;
    private List<String> mPaths=new ArrayList<>();

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
        mRvListImg = findViewById(R.id.imageAddPost);
        mPickImg = findViewById(R.id.img_add);
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
        mPickImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onGallerySelected();
            }
        });
        mBtnPost.setOnClickListener(mBtnPostClickListener);
    }
    @SuppressLint("LongLogTag")
    private void sendPost(){

        postName = mEdtPostName.getText().toString();
        postDescription = mEdtPostDescription.getText().toString();
        String step1 = mEdtStep1.getText().toString();
        String step2 = mEdtStep2.getText().toString();
        String step3 = mEdtStep3.getText().toString();
//        mListImg.add(0,"https://media.cooky.vn/recipe/g3/29930/s800x500/recipe-cover-r29930.jpg");

        if(!step1.equals("")) mStep.add(0,step1);
        if(!step2.equals("")) mStep.add(0,step2);
        if(!step3.equals("")) mStep.add(0,step3);
        if(postName.equals("")){
            Toast.makeText(this, "Vui lòng nhập món ăn", Toast.LENGTH_SHORT).show();
        }
        else{
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            for (String s : mPaths) {
                File file = new File(s);
                RequestBody requestBody = RequestBody.create(
                        MediaType.parse("image/*"),
                        file);
                builder.addFormDataPart("upload", file.getName(), requestBody);
            }
            MultipartBody requestBody = builder.build();
            repository.postImage(requestBody)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::onSuccess, this::onError);
        }

    }

    private void onError(Throwable throwable) {
        Log.d("Do000@@@","fuck");
    }

    private void onSuccess(ImgRepo imgRepo) {
        Log.d("Do000@@@","GOOD");
//        mListPickImg = new ArrayList<>();
        mListPickImg = imgRepo.getImage();
        User user = new User(this);
        mListImg.add(0,mListPickImg);
        repository.postRecipes(postName, postDescription, mStep ,user.getId(),mListImg)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(recipeRepo -> {
//                                Log.d(TAG, "sendPost: " + commentRepo.getComment().getContent());
                            Intent intent = new Intent(this, MainActivity.class);
                            startActivity(intent);
                        },
                        throwable -> {
                            Log.d("Do", "sendPost: " + throwable.getMessage() );
                        });

    }

    protected void onGallerySelected(){
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            Intent intent = new Intent();
                            intent.setType("image/*");
                            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                            intent.setAction(Intent.ACTION_GET_CONTENT);
                            startActivityForResult(Intent.createChooser(intent,"Select Picture"), REQUEST_GALLERY_IMAGE);
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        try {
            // When an Image is picked
            if (requestCode == REQUEST_GALLERY_IMAGE && resultCode == RESULT_OK
                    && null != data) {
                if(data.getData()!=null){
                    mPaths.add(RealPathUtil.getRealPath(PostActivity.this, data.getData()));
                    String PATH = RealPathUtil.getRealPath(PostActivity.this, data.getData());
                    Uri mImageUri= Uri.fromFile(new File(PATH));
                    uri.add(mImageUri);
                } else {
                    if (data.getClipData() != null) {
                        ClipData mClipData = data.getClipData();
                        for (int i = 0; i < mClipData.getItemCount(); i++) {
                            ClipData.Item item = mClipData.getItemAt(i);
                            mPaths.add(RealPathUtil.getRealPath(PostActivity.this, item.getUri()));
                            String PATH = RealPathUtil.getRealPath(PostActivity.this, item.getUri());
                            Uri mImageUri = Uri.fromFile(new File(PATH));
                            uri.add(mImageUri);
                        }
                    }
                }
                mRvListImg.setAdapter(new AddImageAdapter(uri));
                mRvListImg.setLayoutManager(new LinearLayoutManager(PostActivity.this, LinearLayoutManager.HORIZONTAL, false));
            } else {
//                Toast.makeText(this, "Bạn không chọn ảnh",
//                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
//            Toast.makeText(this, "Something went wrong"+e.toString(), Toast.LENGTH_LONG)
//                    .show();
        }
//        Toast.makeText(this,imgName)
        super.onActivityResult(requestCode, resultCode, data);
    }
}
