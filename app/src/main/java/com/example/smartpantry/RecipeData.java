package com.example.smartpantry;

import com.example.smartpantry.models.PantryItem;
import com.example.smartpantry.models.Recipe;

import java.util.ArrayList;

public class RecipeData {

    public static ArrayList<Recipe> getRecipes() {

        ArrayList<Recipe> recipes = new ArrayList<>();

        // Simple Omelette
        ArrayList<PantryItem> omeletteIngredients = new ArrayList<>();

        omeletteIngredients.add(
                new PantryItem("Eggs", 2, "pcs", "")
        );

        omeletteIngredients.add(
                new PantryItem("Tomatoes", 1, "pcs", "")
        );

        recipes.add(
                new Recipe(
                        "Simple Omelette",
                        "A quick omelette made with eggs and tomatoes.",
                        omeletteIngredients
                )
        );

        // Rice and Chicken
        ArrayList<PantryItem> chickenRiceIngredients = new ArrayList<>();

        chickenRiceIngredients.add(
                new PantryItem("Chicken", 500, "g", "")
        );

        chickenRiceIngredients.add(
                new PantryItem("Rice", 250, "g", "")
        );

        recipes.add(
                new Recipe(
                        "Rice and Chicken",
                        "A simple chicken and rice meal.",
                        chickenRiceIngredients
                )
        );

        // Chicken and Mayo Sandwich
        ArrayList<PantryItem> chickenMayoSandwichIngredients = new ArrayList<>();

        chickenMayoSandwichIngredients.add(
                new PantryItem("Chicken", 200, "g", "")
        );

        chickenMayoSandwichIngredients.add(
                new PantryItem("Bread", 2, "pcs", "")
        );

        chickenMayoSandwichIngredients.add(
                new PantryItem("Mayonnaise", 30, "g", "")
        );

        recipes.add(
                new Recipe(
                        "Chicken and Mayo Sandwich",
                        "A simple sandwich made with chicken, bread and mayonnaise.",
                        chickenMayoSandwichIngredients
                )
        );

        return recipes;
    }
}
