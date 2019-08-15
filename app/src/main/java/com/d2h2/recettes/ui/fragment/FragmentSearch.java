package com.d2h2.recettes.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.d2h2.recettes.R;

public class FragmentSearch extends Fragment {
    private TextView mTxtSearch;
    private TextView mTxtSearchResources;
    private TextView mTxtSearchName;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initAction();
    }

    private void initView(View view) {
        mTxtSearch = view.findViewById(R.id.txt_search);
        mTxtSearchResources = view.findViewById(R.id.txt_search_resources);
        mTxtSearchName = view.findViewById(R.id.txt_search_name);
    }

    private void initAction() {
        mTxtSearch.setText(R.string.title_search);
        mTxtSearchResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentSearchResources fragmentSearchresources = new FragmentSearchResources();
                getChildFragmentManager().beginTransaction().replace(R.id.fragment_search, fragmentSearchresources).commit();
            }
        });
        mTxtSearchName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentSearchName fragmentSearchName = new FragmentSearchName();
                getChildFragmentManager().beginTransaction().replace(R.id.fragment_search, fragmentSearchName).commit();
            }
        });
    }
}
