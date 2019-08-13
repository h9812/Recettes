package com.d2h2.recettes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentSetting extends Fragment {
    private TextView mTxtSetting;
    private TextView mTxtLogin;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initAction();
    }

    private void initView(View view) {
        mTxtSetting = view.findViewById(R.id.txt_setting);
        mTxtLogin = view.findViewById(R.id.txt_login);
    }

    private void initAction() {
        mTxtSetting.setText(R.string.title_setting);
        mTxtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
