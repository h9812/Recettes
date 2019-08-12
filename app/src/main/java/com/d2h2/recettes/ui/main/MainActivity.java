package com.d2h2.recettes.ui.main;

import android.os.Bundle;

import com.d2h2.recettes.R;
import com.d2h2.recettes.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
