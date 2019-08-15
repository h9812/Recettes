package com.d2h2.recettes.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.d2h2.recettes.R;
import com.d2h2.recettes.data.model.User;

import java.util.Objects;

public class PostActivity extends AppCompatActivity {
    private ImageView mImgAvatar;
    private TextView mTxtName;
    private TextView mTxtGenre;
    private Button mBtnPost;
    private ImageView mImgBack;
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

}
