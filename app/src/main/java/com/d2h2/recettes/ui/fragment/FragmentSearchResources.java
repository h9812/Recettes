package com.d2h2.recettes.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.d2h2.recettes.R;
import com.d2h2.recettes.data.Repo.CommentsRepo;
import com.d2h2.recettes.data.Repository;
import com.d2h2.recettes.data.model.Ingredient;
import com.d2h2.recettes.data.model.Recipe;
import com.d2h2.recettes.util.AppUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FragmentSearchResources extends Fragment {
    private CompositeDisposable compositeDisposable;
    private Ingredient mIngredient;

    FragmentSearchResources(Ingredient ingredient){
        mIngredient = ingredient;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_search_resources, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        compositeDisposable = new CompositeDisposable();
        initView(view);
        initActions();
    }

    private void initActions() {
        Repository repository = AppUtil.getRepository();
        Disposable disposable = repository.getComments(Ingredient.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
        compositeDisposable.add(disposable);
    }

    private void onSuccess(CommentsRepo commentsRepo) {
    }

    private void initView(View view) {
    }

}
