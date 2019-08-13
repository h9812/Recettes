package com.d2h2.recettes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentHome extends Fragment {
    private TextView mTxtHome;
    private ImageView mImgAdd;
    private final View.OnClickListener mImgAddClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), PostActivity.class);
            startActivity(intent);
        }
    };
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initAction();
    }

    private void initView(View view) {
        mTxtHome = view.findViewById(R.id.txt_home);
        mImgAdd = view.findViewById(R.id.ic_add);
    }
    
    private void initAction() {
        mTxtHome.setText(R.string.title_home);
        mImgAdd.setOnClickListener(mImgAddClickListener);
    }
}
