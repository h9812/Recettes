package com.d2h2.recettes.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.d2h2.recettes.data.model.Recipe;
import com.d2h2.recettes.ui.fragment.FragmentImages;

public class ImagePagerAdapter extends FragmentPagerAdapter {
    private Recipe data;

    public ImagePagerAdapter(FragmentManager fm, Recipe recipe){
        super(fm);
        this.data = recipe;
    }


    @Override
    public Fragment getItem(int i) {
        return FragmentImages.getInstance(i, data);
    }

    @Override
    public int getCount() {
        return data.getImages().size();
    }

}