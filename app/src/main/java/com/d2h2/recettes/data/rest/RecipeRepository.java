package com.d2h2.recettes.data.rest;

import com.d2h2.recettes.data.model.Recipe;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class RecipeRepository {
    private final Repository repository;

    @Inject
    public RecipeRepository(Repository repository) {
        this.repository = repository;
    }

    public Single<List<Recipe>> getRecipeList() {
        return repository.getRecipeList();
    }

    public Single<Recipe> getRecipe(String id) {
        return repository.getRecipe(id);
    }

}
