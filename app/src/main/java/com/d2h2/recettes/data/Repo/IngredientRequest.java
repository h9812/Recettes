package com.d2h2.recettes.data.Repo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IngredientRequest {
    @SerializedName("ingredientIds")
    public List<String> ingredientIds[];
//    @SerializedName("ingredientIds")
//    public List<String> ingredientIds[];
}
