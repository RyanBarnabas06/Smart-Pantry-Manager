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
                            && unitsMatch(
                            pantryItem,
                            requiredIngredient
                    )) {

                        ingredientAvailable = true;
                        break;
                    }
                }

                if (!ingredientAvailable) {
                    recipeCanBeMade = false;
                    break;
                }
            }

            if (recipeCanBeMade) {
                matchingRecipes.add(recipe);
            }
        }

        return matchingRecipes;
    }

    private static boolean unitsMatch(
            PantryItem pantryItem,
            PantryItem requiredIngredient
    ) {

        String pantryUnit =
                normaliseUnit(pantryItem.getUnit());

        String requiredUnit =
                normaliseUnit(requiredIngredient.getUnit());

        // Same unit
        if (pantryUnit.equals(requiredUnit)) {

            return pantryItem.getQuantity()
                    >= requiredIngredient.getQuantity();
        }

        // Convert compatible units to grams
        if (isGramUnit(pantryUnit)
                && isGramUnit(requiredUnit)) {

            double pantryGrams =
                    convertToGrams(
                            pantryItem.getQuantity(),
                            pantryUnit
                    );

            double requiredGrams =
                    convertToGrams(
                            requiredIngredient.getQuantity(),
                            requiredUnit
                    );

            return pantryGrams >= requiredGrams;
        }

        // Convert compatible units to millilitres
        if (isMillilitreUnit(pantryUnit)
                && isMillilitreUnit(requiredUnit)) {

            double pantryMillilitres =
                    convertToMillilitres(
                            pantryItem.getQuantity(),
                            pantryUnit
                    );

            double requiredMillilitres =
                    convertToMillilitres(
                            requiredIngredient.getQuantity(),
                            requiredUnit
                    );

            return pantryMillilitres >= requiredMillilitres;
        }

        // Different incompatible units cannot match
        return false;
    }

    private static String normaliseUnit(String unit) {

        return unit
                .trim()
                .toLowerCase();
    }

    private static boolean isGramUnit(String unit) {

        return unit.equals("g")
                || unit.equals("gram")
                || unit.equals("grams")
                || unit.equals("kg")
                || unit.equals("kilogram")
                || unit.equals("kilograms");
    }

    private static boolean isMillilitreUnit(String unit) {

        return unit.equals("ml")
                || unit.equals("millilitre")
                || unit.equals("millilitres")
                || unit.equals("milliliter")
                || unit.equals("milliliters")
                || unit.equals("litre")
                || unit.equals("litres")
                || unit.equals("liter")
                || unit.equals("liters");
    }

    private static double convertToGrams(
            double quantity,
            String unit
    ) {

        if (unit.equals("kg")
                || unit.equals("kilogram")
                || unit.equals("kilograms")) {

            return quantity * 1000;
        }

        return quantity;
    }

    private static double convertToMillilitres(
            double quantity,
            String unit
    ) {

        if (unit.equals("litre")
                || unit.equals("litres")
                || unit.equals("liter")
                || unit.equals("liters")) {

            return quantity * 1000;
        }

        return quantity;
    }

    private static String normaliseIngredientName(String name) {

        String normalised = name
                .trim()
                .toLowerCase();

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