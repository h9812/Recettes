package com.d2h2.recettes.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.d2h2.recettes.R;
import com.d2h2.recettes.data.model.User;

import java.util.Objects;

public class FragmentProfile extends Fragment {
    private TextView mTxtProfile;
    private TextView mTxtName;
    private TextView mTxtEmail;
    private ImageView mImgAvatar;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initAction();
    }

    private void initView(View view) {
        mTxtProfile = view.findViewById(R.id.txt_profile);
        mImgAvatar = view.findViewById(R.id.img_avatar);
        mTxtName = view.findViewById(R.id.txt_name);
        mTxtEmail = view.findViewById(R.id.txt_email);
    }


    @SuppressLint("NewApi")
    private void initAction() {
        mTxtProfile.setText(R.string.title_profile);
        User user = new User(getActivity());
        mTxtName.setText(user.getName());
        mTxtEmail.setText(user.getEmail());

        Glide.with(Objects.requireNonNull(getContext()))
                .load(user.getUrl_avatar())
                .into(mImgAvatar);
    }
}
