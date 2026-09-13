package com.example.smartpantry;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpantry.models.PantryItem;
import com.example.smartpantry.models.Recipe;

import java.util.ArrayList;

public class RecipesActivity extends AppCompatActivity {

    private RecyclerView rvRecipes;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_recipes);

        getWindow().setStatusBarColor(Color.rgb(35, 35, 35));

        WindowCompat.getInsetsController(
                getWindow(),
                getWindow().getDecorView()
        ).setAppearanceLightStatusBars(false);

        // Move bottom navigation above the phone's navigation bar
        ViewGroup bottomNavigation = findViewById(
                R.id.bottomNavigation
        );

        ViewCompat.setOnApplyWindowInsetsListener(
                bottomNavigation,
                (view, windowInsets) -> {

                    Insets systemBars = windowInsets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    ViewGroup.MarginLayoutParams params =
                            (ViewGroup.MarginLayoutParams) view.getLayoutParams();

                    params.bottomMargin = systemBars.bottom;

                    view.setLayoutParams(params);

                    return windowInsets;
                }
        );

        // Connect RecyclerView
        rvRecipes = findViewById(
                R.id.rvRecipes
        );

        rvRecipes.setLayoutManager(
                new LinearLayoutManager(this)
        );

        // Create database helper
        databaseHelper = new DatabaseHelper(this);

        // Get pantry items from SQLite
        ArrayList<PantryItem> pantryItems =
                databaseHelper.getAllPantryItems();

        // Get all predefined recipes
        ArrayList<Recipe> allRecipes =
                RecipeData.getRecipes();

        // Find recipes that can actually be made
        ArrayList<Recipe> matchingRecipes =
                RecipeMatcher.getMatchingRecipes(
                        pantryItems,
                        allRecipes
                );

        // Create recipe adapter
        RecipeAdapter recipeAdapter =
                new RecipeAdapter(
                        this,
                        matchingRecipes
                );

        // Connect adapter to RecyclerView
        rvRecipes.setAdapter(recipeAdapter);

        // Pantry navigation
        TextView navPantry = findViewById(
                R.id.navPantry
        );

        navPantry.setOnClickListener(v -> {
            finish();
        });
    }
}