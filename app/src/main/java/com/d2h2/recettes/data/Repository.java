package com.d2h2.recettes.data;

import com.d2h2.recettes.data.Repo.IngredientRepo;
import com.d2h2.recettes.data.Repo.IngredientsRepo;
import com.d2h2.recettes.data.Repo.RecipeRepo;
import com.d2h2.recettes.data.Repo.RecipesRepo;
import com.d2h2.recettes.data.model.Ingredient;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Repository {
    @GET("/api/recipes")
    Single<RecipesRepo> getRepositories();

    @GET("api/recipes/{id}")
    Single<RecipeRepo> getRecipe(@Path("id") String id);

    @GET("api/ingredients")
    Single<IngredientsRepo> getIngredientList();

    @GET("api/ingredients/{id}")
    Single<IngredientRepo> getIngredient(@Path("id") String id);
}
