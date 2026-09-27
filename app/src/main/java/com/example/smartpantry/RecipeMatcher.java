package com.example.smartpantry;

import com.example.smartpantry.models.PantryItem;
import com.example.smartpantry.models.Recipe;

import java.util.ArrayList;

public class RecipeMatcher {

    public static ArrayList<Recipe> getMatchingRecipes(
            ArrayList<PantryItem> pantryItems,
            ArrayList<Recipe> recipes
    ) {

        ArrayList<Recipe> matchingRecipes = new ArrayList<>();

        // Check every recipe
        for (Recipe recipe : recipes) {

            boolean recipeCanBeMade = true;

            // Check every ingredient required by the recipe
            for (PantryItem requiredIngredient :
                    recipe.getRequiredIngredients()) {

                boolean ingredientAvailable = false;

                // Look for the required ingredient in the pantry
                for (PantryItem pantryItem : pantryItems) {

                    String pantryName =
                            normaliseIngredientName(
                                    pantryItem.getName()
                            );

                    String requiredName =
                            normaliseIngredientName(
                                    requiredIngredient.getName()
                            );

                    if (pantryName.equals(requiredName)
                            && pantryItem.getUnit().equalsIgnoreCase(
                            requiredIngredient.getUnit()
                    )
                            && pantryItem.getQuantity()
                            >= requiredIngredient.getQuantity()) {

                        ingredientAvailable = true;
                        break;
                    }
                }

                // If one ingredient is missing,
                // the recipe cannot be made
                if (!ingredientAvailable) {
                    recipeCanBeMade = false;
                    break;
                }
            }

            // Only add recipes where ALL ingredients are available
            if (recipeCanBeMade) {
                matchingRecipes.add(recipe);
            }
        }

        return matchingRecipes;
    }

    private static String normaliseIngredientName(String name) {

        String normalised = name
                .trim()
                .toLowerCase();

        // Convert common plural forms to singular
        if (normalised.endsWith("ies")
                && normalised.length() > 3) {

            normalised = normalised.substring(
                    0,
                    normalised.length() - 3
            ) + "y";

        } else if (normalised.endsWith("oes")
                && normalised.length() > 3) {

            normalised = normalised.substring(
                    0,
                    normalised.length() - 2
            );

        } else if (normalised.endsWith("es")
                && normalised.length() > 2) {

            normalised = normalised.substring(
                    0,
                    normalised.length() - 2
            );

        } else if (normalised.endsWith("s")
                && normalised.length() > 1) {

            normalised = normalised.substring(
                    0,
                    normalised.length() - 1
            );
        }

        return normalised;
    }
}