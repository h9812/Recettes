package com.d2h2.recettes.ui.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.d2h2.recettes.R;
import com.d2h2.recettes.data.Repository;
import com.d2h2.recettes.util.AppUtil;

import butterknife.BindView;
import io.reactivex.disposables.CompositeDisposable;

public class PostActivity1 extends AppCompatActivity {

    private CompositeDisposable compositeDisposable;
    private Repository repository = AppUtil.getRepository();
    private int REQUEST_GALLERY_IMAGE = 100;

    @BindView(R.id.img_avatar) ImageView avatarImageView;
    @BindView(R.id.edt_title) EditText titleEditText;
    @BindView(R.id.edt_post_description) EditText descriptionEditText;
    @BindView(R.id.direction_container)
    LinearLayout directionContainerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post1);
        initView();
        initActions();
    }

    private void initView() {
    }

    private void initActions() {

    }

    private void sendPost(){

    }

}
