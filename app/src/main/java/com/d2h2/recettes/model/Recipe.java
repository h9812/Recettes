package com.d2h2.recettes.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Recipe implements Serializable {
    private int id;
    private String name;
    private String description;
    private int[] ingredientIds;
    private List<String> amounts;
    private List<String> directions;
    private int[] tagIds;
    private int ownerId;
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

    public int[] getIngredientIds() {
        return ingredientIds;
    }

    public void setIngredientIds(int[] ingredientIds) {
        this.ingredientIds = ingredientIds;
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

    public int[] getTagIds() {
        return tagIds;
    }

    public void setTagIds(int[] tagIds) {
        this.tagIds = tagIds;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
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
