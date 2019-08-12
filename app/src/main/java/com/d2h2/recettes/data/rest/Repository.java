package com.d2h2.recettes.data.rest;

import com.d2h2.recettes.data.model.Recipe;

import java.util.List;

import io.reactivex.Single;

public interface Repository {

    Single<List<Recipe>> getRecipeList();

    Single<Recipe> getRecipe(String id);
}
