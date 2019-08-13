package com.d2h2.recettes.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Recipe implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("ingredientIds")
    private String[] ingredientIds;
    @SerializedName("amounts")
    private List<String> amounts;
    @SerializedName("directions")
    private List<String> directions;
    @SerializedName("tagIds")
    private String[] tagIds;
    @SerializedName("ownerId")
    private String ownerId;
    @SerializedName("numberOfLikes")
    private int numberOfLikes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getIngredientIds() {
        return ingredientIds;
    }

    public void setIngredientIds(String[] ingredientIds) {
        this.ingredientIds = ingredientIds;
    }

    public String[] getTagIds() {
        return tagIds;
    }

    public void setTagIds(String[] tagIds) {
        this.tagIds = tagIds;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public List<String> getAmounts() {
        return amounts;
    }

    public void setAmounts(List<String> amounts) {
        this.amounts = amounts;
    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

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
