package com.example.smartpantry;

import com.example.smartpantry.models.PantryItem;
import com.example.smartpantry.models.Recipe;

import java.util.ArrayList;

public class RecipeData {

    public static ArrayList<Recipe> getRecipes() {

        ArrayList<Recipe> recipes = new ArrayList<>();

        // 1. Creamy Chicken Pasta
        ArrayList<PantryItem> creamyChickenPasta = new ArrayList<>();

        creamyChickenPasta.add(
                new PantryItem("Chicken", 200, "g", "")
        );

        creamyChickenPasta.add(
                new PantryItem("Pasta", 250, "g", "")
        );

        creamyChickenPasta.add(
                new PantryItem("Cream", 100, "ml", "")
        );

        recipes.add(
                new Recipe(
                        "Creamy Chicken Pasta",
                        "A simple creamy pasta with tender chicken.",
                        "Cook the pasta until tender. Cook the chicken thoroughly, then add the cream. Combine with the pasta and serve.",
                        creamyChickenPasta
                )
        );

        // 2. Bacon and Potato Hash
        ArrayList<PantryItem> baconPotatoHash = new ArrayList<>();

        baconPotatoHash.add(
                new PantryItem("Bacon", 2, "pcs", "")
        );

        baconPotatoHash.add(
                new PantryItem("Potatoes", 3, "pcs", "")
        );

        recipes.add(
                new Recipe(
                        "Bacon and Potato Hash",
                        "A hearty dish made with crispy bacon and potatoes.",
                        "Cut the potatoes into small pieces and cook until golden. Add the bacon and cook until crispy.",
                        baconPotatoHash
                )
        );

        // 3. Chicken Mayo Toastie
        ArrayList<PantryItem> chickenMayoToastie = new ArrayList<>();

        chickenMayoToastie.add(
                new PantryItem("Chicken", 100, "g", "")
        );

        chickenMayoToastie.add(
                new PantryItem("Bread", 2, "pcs", "")
        );

        chickenMayoToastie.add(
                new PantryItem("Mayonnaise", 20, "ml", "")
        );

        recipes.add(
                new Recipe(
                        "Chicken Mayo Toastie",
                        "A toasted sandwich filled with chicken and mayonnaise.",
                        "Cook the chicken thoroughly and slice it. Mix with mayonnaise, place between the bread and toast until golden.",
                        chickenMayoToastie
                )
        );

        // 4. Cheesy Egg Toast
        ArrayList<PantryItem> cheesyEggToast = new ArrayList<>();

        cheesyEggToast.add(
                new PantryItem("Eggs", 2, "pcs", "")
        );

        cheesyEggToast.add(
                new PantryItem("Bread", 2, "pcs", "")
        );

        cheesyEggToast.add(
                new PantryItem("Cheese", 30, "g", "")
        );

        recipes.add(
                new Recipe(
                        "Cheesy Egg Toast",
                        "A quick breakfast with eggs, bread and melted cheese.",
                        "Cook the eggs and place them on the bread. Add cheese and toast until the cheese melts.",
                        cheesyEggToast
                )
        );

        // 5. Chicken and Rice Bowl
        ArrayList<PantryItem> chickenRiceBowl = new ArrayList<>();

        chickenRiceBowl.add(
                new PantryItem("Chicken", 200, "g", "")
        );

        chickenRiceBowl.add(
                new PantryItem("Rice", 250, "g", "")
        );

        recipes.add(
                new Recipe(
                        "Chicken and Rice Bowl",
                        "A simple bowl of seasoned chicken and rice.",
                        "Cook the rice until tender. Cook the chicken thoroughly and serve over the cooked rice.",
                        chickenRiceBowl
                )
        );

        // 6. Bacon and Egg Wrap
        ArrayList<PantryItem> baconEggWrap = new ArrayList<>();

        baconEggWrap.add(
                new PantryItem("Bacon", 2, "pcs", "")
        );

        baconEggWrap.add(
                new PantryItem("Eggs", 2, "pcs", "")
        );

        baconEggWrap.add(
                new PantryItem("Wrap", 1, "pcs", "")
        );

        recipes.add(
                new Recipe(
                        "Bacon and Egg Wrap",
                        "A quick wrap filled with bacon and scrambled eggs.",
                        "Cook the bacon until crispy. Scramble the eggs, place both inside the wrap and fold before serving.",
                        baconEggWrap
                )
        );

        // 7. Creamy Garlic Chicken
        ArrayList<PantryItem> creamyGarlicChicken = new ArrayList<>();

        creamyGarlicChicken.add(
                new PantryItem("Chicken", 200, "g", "")
        );

        creamyGarlicChicken.add(
                new PantryItem("Cream", 100, "ml", "")
        );

        creamyGarlicChicken.add(
                new PantryItem("Garlic", 2, "pcs", "")
        );

        recipes.add(
                new Recipe(
                        "Creamy Garlic Chicken",
                        "Chicken cooked in a simple creamy garlic sauce.",
                        "Cook the chicken thoroughly. Add chopped garlic and cook briefly before adding the cream. Simmer and serve.",
                        creamyGarlicChicken
                )
        );

        // 8. Loaded Potato Bake
        ArrayList<PantryItem> loadedPotatoBake = new ArrayList<>();

        loadedPotatoBake.add(
                new PantryItem("Potatoes", 4, "pcs", "")
        );

        loadedPotatoBake.add(
                new PantryItem("Bacon", 2, "pcs", "")
        );

        loadedPotatoBake.add(
                new PantryItem("Cheese", 50, "g", "")
        );

        recipes.add(
                new Recipe(
                        "Loaded Potato Bake",
                        "Baked potatoes topped with bacon and melted cheese.",
                        "Cook the potatoes until tender. Add cooked bacon and cheese, then bake until the cheese has melted.",
                        loadedPotatoBake
                )
        );

        // 9. Chicken Vegetable Stir-Fry
        ArrayList<PantryItem> chickenVegetableStirFry = new ArrayList<>();

        chickenVegetableStirFry.add(
                new PantryItem("Chicken", 200, "g", "")
        );

        chickenVegetableStirFry.add(
                new PantryItem("Mixed Vegetables", 200, "g", "")
        );

        recipes.add(
                new Recipe(
                        "Chicken Vegetable Stir-Fry",
                        "A quick stir-fry combining chicken and vegetables.",
                        "Cut the chicken into small pieces and cook thoroughly. Add the vegetables and stir-fry until tender.",
                        chickenVegetableStirFry
                )
        );

        // 10. Egg and Potato Breakfast
        ArrayList<PantryItem> eggPotatoBreakfast = new ArrayList<>();

        eggPotatoBreakfast.add(
                new PantryItem("Eggs", 2, "pcs", "")
        );

        eggPotatoBreakfast.add(
                new PantryItem("Potatoes", 2, "pcs", "")
        );

        recipes.add(
                new Recipe(
                        "Egg and Potato Breakfast",
                        "A filling breakfast made with potatoes and eggs.",
                        "Cook the potatoes until golden. Add the eggs and cook until they are fully set.",
                        eggPotatoBreakfast
                )
        );

        // 11. Creamy Bacon Pasta
        ArrayList<PantryItem> creamyBaconPasta = new ArrayList<>();

        creamyBaconPasta.add(
                new PantryItem("Bacon", 3, "pcs", "")
        );

        creamyBaconPasta.add(
                new PantryItem("Pasta", 250, "g", "")
        );

        creamyBaconPasta.add(
                new PantryItem("Cream", 100, "ml", "")
        );

        recipes.add(
                new Recipe(
                        "Creamy Bacon Pasta",
                        "Pasta combined with crispy bacon and a creamy sauce.",
                        "Cook the pasta. Fry the bacon until crispy, add the cream and combine with the cooked pasta.",
                        creamyBaconPasta
                )
        );

        // 12. Chicken Cheese Toastie
        ArrayList<PantryItem> chickenCheeseToastie = new ArrayList<>();

        chickenCheeseToastie.add(
                new PantryItem("Chicken", 100, "g", "")
        );

        chickenCheeseToastie.add(
                new PantryItem("Bread", 2, "pcs", "")
        );

        chickenCheeseToastie.add(
                new PantryItem("Cheese", 30, "g", "")
        );

        recipes.add(
                new Recipe(
                        "Chicken Cheese Toastie",
                        "A toasted sandwich filled with chicken and melted cheese.",
                        "Cook the chicken thoroughly and slice it. Place chicken and cheese between the bread and toast until golden.",
                        chickenCheeseToastie
                )
        );

        // 13. Bacon Potato Skillet
        ArrayList<PantryItem> baconPotatoSkillet = new ArrayList<>();

        baconPotatoSkillet.add(
                new PantryItem("Bacon", 2, "pcs", "")
        );

        baconPotatoSkillet.add(
                new PantryItem("Potatoes", 3, "pcs", "")
        );

        baconPotatoSkillet.add(
                new PantryItem("Onion", 1, "pcs", "")
        );

        recipes.add(
                new Recipe(
                        "Bacon Potato Skillet",
                        "Crispy potatoes cooked with bacon and onion.",
                        "Cook the chopped potatoes until golden. Add the bacon and onion and cook until everything is tender.",
                        baconPotatoSkillet
                )
        );

        // 14. Chicken Egg Fried Rice
        ArrayList<PantryItem> chickenEggFriedRice = new ArrayList<>();

        chickenEggFriedRice.add(
                new PantryItem("Chicken", 150, "g", "")
        );

        chickenEggFriedRice.add(
                new PantryItem("Rice", 250, "g", "")
        );

        chickenEggFriedRice.add(
                new PantryItem("Eggs", 2, "pcs", "")
        );

        recipes.add(
                new Recipe(
                        "Chicken Egg Fried Rice",
                        "Fried rice with chicken and scrambled egg.",
                        "Cook the chicken thoroughly. Add cooked rice and eggs, then stir-fry until everything is heated through.",
                        chickenEggFriedRice
                )
        );

        // 15. Mayo Chicken Wrap
        ArrayList<PantryItem> mayoChickenWrap = new ArrayList<>();

        mayoChickenWrap.add(
                new PantryItem("Chicken", 100, "g", "")
        );

        mayoChickenWrap.add(
                new PantryItem("Mayonnaise", 20, "ml", "")
        );

        mayoChickenWrap.add(
                new PantryItem("Wrap", 1, "pcs", "")
        );

        recipes.add(
                new Recipe(
                        "Mayo Chicken Wrap",
                        "A simple chicken wrap with a creamy mayonnaise filling.",
                        "Cook the chicken thoroughly and slice it. Mix with mayonnaise, place inside the wrap and fold.",
                        mayoChickenWrap
                )
        );

        // 16. Cheesy Bacon Potatoes
        ArrayList<PantryItem> cheesyBaconPotatoes = new ArrayList<>();

        cheesyBaconPotatoes.add(
                new PantryItem("Bacon", 2, "pcs", "")
        );

        cheesyBaconPotatoes.add(
                new PantryItem("Potatoes", 3, "pcs", "")
        );

        cheesyBaconPotatoes.add(
                new PantryItem("Cheese", 50, "g", "")
        );

        recipes.add(
                new Recipe(
                        "Cheesy Bacon Potatoes",
                        "Potatoes topped with crispy bacon and melted cheese.",
                        "Cook the potatoes until tender. Add cooked bacon and cheese, then heat until the cheese melts.",
                        cheesyBaconPotatoes
                )
        );

        // 17. Chicken Pasta Bake
        ArrayList<PantryItem> chickenPastaBake = new ArrayList<>();

        chickenPastaBake.add(
                new PantryItem("Chicken", 200, "g", "")
        );

        chickenPastaBake.add(
                new PantryItem("Pasta", 250, "g", "")
        );

        chickenPastaBake.add(
                new PantryItem("Cheese", 50, "g", "")
        );

        recipes.add(
                new Recipe(
                        "Chicken Pasta Bake",
                        "A baked pasta dish with chicken and melted cheese.",
                        "Cook the pasta and chicken. Combine them, add cheese and bake until the cheese is golden.",
                        chickenPastaBake
                )
        );

        // 18. Egg and Bacon Toast
        ArrayList<PantryItem> eggBaconToast = new ArrayList<>();

        eggBaconToast.add(
                new PantryItem("Eggs", 2, "pcs", "")
        );

        eggBaconToast.add(
                new PantryItem("Bacon", 2, "pcs", "")
        );

        eggBaconToast.add(
                new PantryItem("Bread", 2, "pcs", "")
        );

        recipes.add(
                new Recipe(
                        "Egg and Bacon Toast",
                        "Toast topped with eggs and crispy bacon.",
                        "Cook the bacon and eggs thoroughly. Toast the bread and serve with the cooked ingredients.",
                        eggBaconToast
                )
        );

        // 19. Creamy Potato Soup
        ArrayList<PantryItem> creamyPotatoSoup = new ArrayList<>();

        creamyPotatoSoup.add(
                new PantryItem("Potatoes", 4, "pcs", "")
        );

        creamyPotatoSoup.add(
                new PantryItem("Cream", 100, "ml", "")
        );

        recipes.add(
                new Recipe(
                        "Creamy Potato Soup",
                        "A simple creamy soup made with potatoes.",
                        "Cook the potatoes until soft. Mash or blend them, add the cream and heat gently before serving.",
                        creamyPotatoSoup
                )
        );

        // 20. Chicken Potato Bake
        ArrayList<PantryItem> chickenPotatoBake = new ArrayList<>();

        chickenPotatoBake.add(
                new PantryItem("Chicken", 200, "g", "")
        );

        chickenPotatoBake.add(
                new PantryItem("Potatoes", 3, "pcs", "")
        );

        chickenPotatoBake.add(
                new PantryItem("Cheese", 50, "g", "")
        );

        recipes.add(
                new Recipe(
                        "Chicken Potato Bake",
                        "A baked dish combining chicken, potatoes and cheese.",
                        "Cook the chicken thoroughly and slice it. Layer with cooked potatoes, add cheese and bake until golden.",
                        chickenPotatoBake
                )
        );

        return recipes;
    }
}