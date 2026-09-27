package com.example.smartpantry;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpantry.models.Recipe;

import java.util.ArrayList;

public class RecipeGuideActivity extends AppCompatActivity {

    private RecyclerView rvRecipeGuide;

    private DatabaseHelper databaseHelper;

    private RecipeGuideAdapter recipeGuideAdapter;

    private ArrayList<Recipe> recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_recipe_guide);

        getWindow().setStatusBarColor(
                Color.rgb(35, 35, 35)
        );

        WindowCompat.getInsetsController(
                getWindow(),
                getWindow().getDecorView()
        ).setAppearanceLightStatusBars(false);

        // Connect RecyclerView
        rvRecipeGuide = findViewById(
                R.id.rvRecipeGuide
        );

        rvRecipeGuide.setLayoutManager(
                new LinearLayoutManager(this)
        );

        // Create database helper
        databaseHelper = new DatabaseHelper(this);

        // Get all recipes from SQLite
        recipes = databaseHelper.getAllRecipes();

        // Create adapter
        recipeGuideAdapter =
                new RecipeGuideAdapter(
                        this,
                        recipes
                );

        // Connect adapter
        rvRecipeGuide.setAdapter(
                recipeGuideAdapter
        );

        // Back to Recipes button
        Button btnBackToRecipes = findViewById(
                R.id.btnBackToRecipes
        );

        btnBackToRecipes.setOnClickListener(v -> finish());
    }
}
