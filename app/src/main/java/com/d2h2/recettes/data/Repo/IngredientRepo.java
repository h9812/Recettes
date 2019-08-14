package com.d2h2.recettes.data.Repo;

import com.d2h2.recettes.data.model.Ingredient;
import com.google.gson.annotations.SerializedName;

public class IngredientRepo {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private Ingredient ingredient;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
