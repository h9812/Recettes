package com.d2h2.recettes.data.Repo;

import com.d2h2.recettes.data.model.Recipe;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class RecipesRepo {
    @Getter
    @Setter
    @SerializedName("status")
    private String status;

    @Getter
    @Setter
    @SerializedName("message")
    private String message;

    @Getter
    @Setter
    @SerializedName("data")
    private List<Recipe> recipes;

    public RecipesRepo() {
    }

    public RecipesRepo(String status, String message, List<Recipe> recipes) {
        this.status = status;
        this.message = message;
        this.recipes = recipes;
    }
}
