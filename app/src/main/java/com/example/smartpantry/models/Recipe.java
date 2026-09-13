package com.example.smartpantry.models;

import java.util.ArrayList;

public class Recipe {

    private String name;
    private String description;
    private ArrayList<PantryItem> requiredIngredients;

    public Recipe(
            String name,
            String description,
            ArrayList<PantryItem> requiredIngredients
    ) {
        this.name = name;
        this.description = description;
        this.requiredIngredients = requiredIngredients;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<PantryItem> getRequiredIngredients() {
        return requiredIngredients;
    }
}