package com.example.smartpantry;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
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

    private RecipeAdapter recipeAdapter;

    private ArrayList<Recipe> matchingRecipes;

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
                            (ViewGroup.MarginLayoutParams)
                                    view.getLayoutParams();

                    params.bottomMargin = systemBars.bottom;

                    view.setLayoutParams(params);

                    return windowInsets;
                }
        );

        // Connect Recipes RecyclerView
        rvRecipes = findViewById(R.id.rvRecipes);

        rvRecipes.setLayoutManager(
                new LinearLayoutManager(this)
        );

        // Connect no-recipes message
        TextView tvNoRecipes = findViewById(
                R.id.tvNoRecipes
        );

        // Create database helper
        databaseHelper = new DatabaseHelper(this);

        // Get pantry items from database
        ArrayList<PantryItem> pantryItems =
                databaseHelper.getAllPantryItems();

        // Get all available recipes
        ArrayList<Recipe> recipes =
                databaseHelper.getAllRecipes();

        // Find recipes that can be made using pantry items
        matchingRecipes =
                RecipeMatcher.getMatchingRecipes(
                        pantryItems,
                        recipes
                );

        // Create adapter using matching recipes
        recipeAdapter = new RecipeAdapter(
                this,
                matchingRecipes
        );

        // Connect adapter to RecyclerView
        rvRecipes.setAdapter(recipeAdapter);

        // Show feedback when no recipes match
        if (matchingRecipes.isEmpty()) {

            tvNoRecipes.setVisibility(View.VISIBLE);
            rvRecipes.setVisibility(View.GONE);

        } else {

            tvNoRecipes.setVisibility(View.GONE);
            rvRecipes.setVisibility(View.VISIBLE);
        }

        // Pantry navigation
        TextView navPantry = findViewById(
                R.id.navPantry
        );

        navPantry.setOnClickListener(v -> {

            Intent intent = new Intent(
                    RecipesActivity.this,
                    MainActivity.class
            );

            startActivity(intent);
            finish();
        });

        // Settings navigation
        TextView navSettings = findViewById(
                R.id.navSettings
        );

        navSettings.setOnClickListener(v -> {

            Intent intent = new Intent(
                    RecipesActivity.this,
                    SettingsActivity.class
            );

            startActivity(intent);
            finish();
        });
    }
}