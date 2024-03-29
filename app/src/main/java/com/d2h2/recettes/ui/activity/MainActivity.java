package com.d2h2.recettes.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.d2h2.recettes.R;
import com.d2h2.recettes.ui.fragment.FragmentHome;
import com.d2h2.recettes.ui.fragment.FragmentProfile;
import com.d2h2.recettes.ui.fragment.FragmentSearch;
import com.d2h2.recettes.ui.fragment.FragmentSetting;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentHome fragmentHome = new FragmentHome();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragmentHome).commit();
                    return true;
                case R.id.navigation_search:
                    FragmentSearch fragmentSearch = new FragmentSearch();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragmentSearch).commit();
                    return true;
                case R.id.navigation_profile:
                    FragmentProfile fragmentProfile = new FragmentProfile();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragmentProfile).commit();

                    return true;
                case R.id.navigation_setting:
                    FragmentSetting fragmentSetting = new FragmentSetting();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragmentSetting).commit();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentHome fragmentHome = new FragmentHome();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragmentHome).commit();
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
