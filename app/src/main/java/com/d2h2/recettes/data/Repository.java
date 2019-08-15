package com.d2h2.recettes.data;

import com.d2h2.recettes.data.Repo.CommentsRepo;
import com.d2h2.recettes.data.Repo.IngredientRepo;
import com.d2h2.recettes.data.Repo.IngredientsRepo;
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

    @GET("api/search/ingredients/{recipe_id}")
    Single<IngredientsRepo> getIngredientList(@Path("recipe_id") String id);

    @GET("api/ingredients/{id}")
    Single<IngredientRepo> getIngredient(@Path("id") String id);

    @GET("api/search/comments/{recipe_id}")
    Single<CommentsRepo> getComments(@Path("recipe_id") String id);
}
