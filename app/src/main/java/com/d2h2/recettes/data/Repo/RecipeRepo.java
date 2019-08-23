package com.d2h2.recettes.data.Repo;

import com.d2h2.recettes.data.model.Recipe;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class RecipeRepo {
    @Getter
    @Setter
    @SerializedName("message")
    private String message;

    @Getter
    @Setter
    @SerializedName("data")
    private Recipe recipe;
}
