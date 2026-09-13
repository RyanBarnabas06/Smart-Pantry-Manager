package com.example.smartpantry;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.example.smartpantry.models.PantryItem;
import com.example.smartpantry.models.Recipe;

import java.util.ArrayList;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_recipe_detail);

        // Keep status bar icons white
        getWindow().setStatusBarColor(Color.rgb(35, 35, 35));

        WindowCompat.getInsetsController(
                getWindow(),
                getWindow().getDecorView()
        ).setAppearanceLightStatusBars(false);

        // Connect views
        TextView tvRecipeName = findViewById(
                R.id.tvRecipeDetailName
        );

        TextView tvRecipeDescription = findViewById(
                R.id.tvRecipeDetailDescription
        );

        TextView tvRecipeIngredients = findViewById(
                R.id.tvRecipeDetailIngredients
        );

        Button btnBack = findViewById(
                R.id.btnBackToRecipes
        );

        // Get recipe name passed through the Intent
        String recipeName = getIntent().getStringExtra(
                "recipe_name"
        );

        // Find the matching recipe
        Recipe selectedRecipe = null;

        ArrayList<Recipe> recipes = RecipeData.getRecipes();

        for (Recipe recipe : recipes) {

            if (recipe.getName().equals(recipeName)) {

                selectedRecipe = recipe;
                break;
            }
        }

        // Display recipe information
        if (selectedRecipe != null) {

            tvRecipeName.setText(
                    selectedRecipe.getName()
            );

            tvRecipeDescription.setText(
                    selectedRecipe.getDescription()
            );

            // Build ingredient list
            StringBuilder ingredientsText =
                    new StringBuilder();

            for (PantryItem ingredient :
                    selectedRecipe.getRequiredIngredients()) {

                ingredientsText.append("• ")
                        .append(ingredient.getName())
                        .append(" - ")
                        .append(ingredient.getQuantity())
                        .append(" ")
                        .append(ingredient.getUnit())
                        .append("\n");
            }

            tvRecipeIngredients.setText(
                    ingredientsText.toString().trim()
            );
        }

        // Back button
        btnBack.setOnClickListener(v -> finish());
    }
}