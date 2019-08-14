package com.d2h2.recettes.data;

import com.d2h2.recettes.data.Repo.RecipeRepo;
import com.d2h2.recettes.data.Repo.RecipesRepo;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Repository {
    @GET("/api/recipes")
    Single<RecipesRepo> getRepositories();

    @GET("api/recipes/{id}")
    Single<RecipeRepo> getRecipe(@Path("id") String id);
}
