package com.d2h2.recettes.data.Repo;

import com.d2h2.recettes.data.model.Recipe;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipesRepo {
    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<Recipe> recipes;

    public RecipesRepo() {
    }

    public RecipesRepo(String status, String message, List<Recipe> recipes) {
        this.status = status;
        this.message = message;
        this.recipes = recipes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
