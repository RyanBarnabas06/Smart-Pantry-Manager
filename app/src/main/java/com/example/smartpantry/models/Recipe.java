package com.example.smartpantry.models;

import java.util.ArrayList;

public class Recipe {

    private String name;
    private String description;
    private String method;
    private ArrayList<PantryItem> requiredIngredients;

    public Recipe(
            String name,
            String description,
            String method,
            ArrayList<PantryItem> requiredIngredients
    ) {
        this.name = name;
        this.description = description;
        this.method = method;
        this.requiredIngredients = requiredIngredients;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMethod() {
        return method;
    }

    public ArrayList<PantryItem> getRequiredIngredients() {
        return requiredIngredients;
    }
}