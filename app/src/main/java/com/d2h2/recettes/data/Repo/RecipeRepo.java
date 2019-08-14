package com.d2h2.recettes.data.Repo;

import com.d2h2.recettes.data.model.Recipe;
import com.google.gson.annotations.SerializedName;

public class RecipeRepo {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private Recipe recipe;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
