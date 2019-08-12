package com.d2h2.recettes.data.model;

public class Recipe {
    public final String id;
    public final String name;
    public final String description;

    public Recipe(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
