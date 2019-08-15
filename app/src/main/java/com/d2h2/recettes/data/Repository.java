package com.d2h2.recettes.data;

import com.d2h2.recettes.data.Repo.RecipesRepo;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Repository {
    @GET("/api/recipes")
    Single<RecipesRepo> getRepositories();
//    @GET("/api/recipes/comment")
//    Single<RecipesRepo> getRepositories();
}
