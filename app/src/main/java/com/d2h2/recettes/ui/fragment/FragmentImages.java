package com.d2h2.recettes.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.d2h2.recettes.R;
import com.d2h2.recettes.data.model.Recipe;
import com.d2h2.recettes.util.AppUtil;

public class FragmentImages extends Fragment {
    private static Recipe data;
    private static final String KEY_IMAGE = "key_image";

    private FragmentImages() {
    }

    public static FragmentImages getInstance(int image, Recipe recipe){
        data = recipe;
        FragmentImages fragment = new FragmentImages();
        Bundle args = new Bundle();
        args.putInt(KEY_IMAGE, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.image_item, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imv_image);
        for(int i = 0; i < data.getImages().size(); i ++){
            if(getArguments().getInt(KEY_IMAGE) == i){
                Glide.with(this).load(AppUtil.IP + data.getImages().get(i)).into(imageView);
            }
        }
        return rootView;
    }
}
