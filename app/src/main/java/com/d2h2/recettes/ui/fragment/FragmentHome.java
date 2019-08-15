package com.d2h2.recettes.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.d2h2.recettes.R;
import com.d2h2.recettes.data.Repo.RecipesRepo;
import com.d2h2.recettes.data.Repository;
import com.d2h2.recettes.data.model.Recipe;
import com.d2h2.recettes.ui.activity.PostActivity;
import com.d2h2.recettes.ui.adapter.HomeAdapter;
import com.d2h2.recettes.ui.fragment.listener.RecipeSelectedListener;
import com.d2h2.recettes.util.AppUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FragmentHome extends Fragment{

    @BindView(R.id.rv_recipes)
    RecyclerView recyclerView;
    private CompositeDisposable compositeDisposable;
    private ImageView mImgAdd;
    private RecipeSelectedListener mRecipeSelectedListener;
    private final View.OnClickListener mImgAddClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), PostActivity.class);
            startActivity(intent);
        }
    };
    private final RecipeSelectedListener mRecipesClickListener = new RecipeSelectedListener() {
        @Override
        public void onRecipeSelected(Recipe recipe) {
            Toast.makeText(getContext(), "on Click", Toast.LENGTH_SHORT).show();
            FragmentDetailRecipe fragmentDetailRecipe = new FragmentDetailRecipe();
            recyclerView.setVisibility(View.GONE);
            getChildFragmentManager().beginTransaction().replace(R.id.list_recipes, fragmentDetailRecipe).commit();
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        compositeDisposable = new CompositeDisposable();
        initView(view);
        initAction();
    }

    private void initView(View view) {
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mImgAdd = view.findViewById(R.id.ic_add);
    }
    
    private void initAction() {
        Repository repository = AppUtil.getRepository();
        Disposable disposable = repository.getRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
        compositeDisposable.add(disposable);

        mImgAdd.setOnClickListener(mImgAddClickListener);
    }

    private void onSuccess(RecipesRepo recipesRepo){
        List<Recipe> recipes = new ArrayList<>();
        recipes = recipesRepo.getRecipes();
        HomeAdapter homeAdapter = new HomeAdapter(recipes);
        homeAdapter.onClickRecipes(mRecipesClickListener);
        recyclerView.setAdapter(homeAdapter);
    }

    private void onError(Throwable e){
        Log.d("dinh", "onError: " + e);
        Toast.makeText(getContext(), "Error: " + e, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
