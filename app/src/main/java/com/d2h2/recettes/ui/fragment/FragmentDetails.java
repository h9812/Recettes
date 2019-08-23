package com.d2h2.recettes.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.d2h2.recettes.R;
import com.d2h2.recettes.data.Repo.RecipeRepo;
import com.d2h2.recettes.data.Repository;
import com.d2h2.recettes.data.model.Recipe;
import com.d2h2.recettes.ui.adapter.ImagePagerAdapter;
import com.d2h2.recettes.util.AppUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FragmentDetails extends Fragment {

    @BindView(R.id.tv_recipe_name)
    TextView recipeNameTextView;
    @BindView(R.id.tv_recipe_description)
    TextView recipeDescriptionTextView;
    @BindView(R.id.tv_directions)
    TextView directionTextView;
    @BindView(R.id.tv_ingredient)
    TextView ingredientTextView;
    @BindView(R.id.tv_comment)
    TextView commentTextView;
    @BindView(R.id.vp_images)
    ViewPager imagesViewPager;
    private CompositeDisposable compositeDisposable;
    private Recipe data;

    FragmentDetails(Recipe recipe) {
        this.data = recipe;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
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
    }

    private void initAction() {
        Repository repository = AppUtil.getRepository();
        Disposable disposable = repository.getRecipe(data.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
        compositeDisposable.add(disposable);
    }


    private void onSuccess(RecipeRepo recipeRepo) {
        Recipe recipe = recipeRepo.getRecipe();
        recipeNameTextView.setText(recipe.getName());
        recipeDescriptionTextView.setText(recipe.getDescription());
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getChildFragmentManager(), recipe);
        imagesViewPager.setAdapter(imagePagerAdapter);
        directionTextView.setOnClickListener(view -> {
            directionTextView.setTextColor(getResources().getColor(R.color.colorOrange));
            ingredientTextView.setTextColor(getResources().getColor(R.color.colorBlue3));
            commentTextView.setTextColor(getResources().getColor(R.color.colorBlue3));
            openDirection(recipe);
        });
        ingredientTextView.setOnClickListener(view -> {
            directionTextView.setTextColor(getResources().getColor(R.color.colorBlue3));
            ingredientTextView.setTextColor(getResources().getColor(R.color.colorOrange));
            commentTextView.setTextColor(getResources().getColor(R.color.colorBlue3));
            openIngredient(recipe);
        });
        commentTextView.setOnClickListener(view -> {
            directionTextView.setTextColor(getResources().getColor(R.color.colorBlue3));
            ingredientTextView.setTextColor(getResources().getColor(R.color.colorBlue3));
            commentTextView.setTextColor(getResources().getColor(R.color.colorOrange));
            openComment(recipe);
        });
        openDirection(recipe);

    }

    private void onError(Throwable e) {
        Log.d("dinh", "onError: " + e);
        Toast.makeText(getContext(), "Error: " + e, Toast.LENGTH_SHORT).show();
    }

    private void openDirection(Recipe recipe) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, new FragmentDirections(recipe))
                .addToBackStack(null).commit();
    }

    private void openIngredient(Recipe recipe) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, new FragmentIngredients(recipe))
                .addToBackStack(null).commit();
    }

    private void openComment(Recipe recipe) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, new FragmentComments(recipe))
                .addToBackStack(null).commit();
    }
}
