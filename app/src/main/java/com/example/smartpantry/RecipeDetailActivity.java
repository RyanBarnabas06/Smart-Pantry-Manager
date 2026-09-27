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

        getWindow().setStatusBarColor(Color.rgb(35, 35, 35));

        WindowCompat.getInsetsController(
                getWindow(),
                getWindow().getDecorView()
        ).setAppearanceLightStatusBars(false);

        TextView tvRecipeName = findViewById(
                R.id.tvRecipeDetailName
        );

        TextView tvRecipeDescription = findViewById(
                R.id.tvRecipeDetailDescription
        );

        TextView tvRecipeIngredients = findViewById(
                R.id.tvRecipeDetailIngredients
        );

        TextView tvRecipeMethod = findViewById(
                R.id.tvRecipeDetailMethod
        );

        Button btnBack = findViewById(
                R.id.btnBackToRecipes
        );

        String recipeName = getIntent().getStringExtra(
                "recipe_name"
        );

        DatabaseHelper databaseHelper =
                new DatabaseHelper(this);

        ArrayList<Recipe> recipes =
                databaseHelper.getAllRecipes();

        Recipe selectedRecipe = null;

        for (Recipe recipe : recipes) {

            if (recipe.getName().equals(recipeName)) {
                selectedRecipe = recipe;
                break;
            }
        }

        if (selectedRecipe != null) {

            tvRecipeName.setText(
                    selectedRecipe.getName()
            );

            tvRecipeDescription.setText(
                    selectedRecipe.getDescription()
            );

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

            tvRecipeMethod.setText(
                    selectedRecipe.getMethod()
            );
        }

        btnBack.setOnClickListener(v -> finish());
    }
}