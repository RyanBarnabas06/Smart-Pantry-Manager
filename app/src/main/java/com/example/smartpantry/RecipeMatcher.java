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

                    if (pantryItem.getName().equalsIgnoreCase(
                            requiredIngredient.getName()
                    )
                            && pantryItem.getUnit().equalsIgnoreCase(
                            requiredIngredient.getUnit()
                    )
                            && pantryItem.getQuantity()
                            >= requiredIngredient.getQuantity()) {

                        ingredientAvailable = true;
                        break;
                    }
                }

                // If even one ingredient is missing,
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
}
