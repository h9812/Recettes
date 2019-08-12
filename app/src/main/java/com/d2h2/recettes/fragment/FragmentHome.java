package com.d2h2.recettes.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.d2h2.recettes.R;
import com.d2h2.recettes.model.Recipe;
import com.d2h2.recettes.repository.RecipeRepo;

import java.util.List;

public class FragmentHome extends Fragment {

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private RecipeRepo.EventListener mRecipeRepoEventListener = new RecipeRepo.EventListener() {
        @Override
        public void onDataChange() {
            mAdapter.clear();
            List<Recipe> recipes = RecipeRepo.getInstance().getList();
            for(Recipe recipe : recipes) {
                mAdapter.add(recipes.toString());
            }
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled() {

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecipeRepo.getInstance().addEventListener(mRecipeRepoEventListener);
    }

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
        mListView = getActivity().findViewById(R.id.list_recipes);
    }
    
    private void initAction() {
        mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        mListView.setAdapter(mAdapter);

    }

    @Override
    public void onDestroy() {
        RecipeRepo.getInstance().removeEventLisstener(mRecipeRepoEventListener);
        super.onDestroy();
    }
}
