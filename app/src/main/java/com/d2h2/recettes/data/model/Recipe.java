package com.d2h2.recettes.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Recipe implements Serializable {
    @Getter
    @Setter
    @SerializedName("_id")
    private String id;

    @Getter
    @Setter
    @SerializedName("name")
    private String name;

    @Getter
    @Setter
    @SerializedName("description")
    private String description;

    @Getter
    @Setter
    @SerializedName("ingredientIds")
    private String[] ingredientIds;

    @Getter
    @Setter
    @SerializedName("ingredientAmounts")
    private List<String> amounts;

    @Getter
    @Setter
    @SerializedName("directions")
    private List<String> directions;

    @Getter
    @Setter
    @SerializedName("tagIds")
    private String[] tagIds;

    @Getter
    @Setter
    @SerializedName("ownerId")
    private String ownerId;

    @Getter
    @Setter
    @SerializedName("numberOfLikes")
    private int numberOfLikes;

    @Getter
    @Setter
    @SerializedName("images")
    private List<String> images;

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredientIds=" + Arrays.toString(ingredientIds) +
                ", amounts=" + amounts +
                ", directions=" + directions +
                ", tagIds=" + Arrays.toString(tagIds) +
                ", ownerId=" + ownerId +
                ", numberOfLikes=" + numberOfLikes +
                '}';
    }
}
