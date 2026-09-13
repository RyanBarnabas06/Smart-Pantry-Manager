package com.example.smartpantry;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPantryItems;

    private DatabaseHelper databaseHelper;

    private PantryAdapter pantryAdapter;

    private ArrayList<PantryItem> pantryItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(Color.rgb(35, 35, 35));

        WindowCompat.getInsetsController(
                getWindow(),
                getWindow().getDecorView()
        ).setAppearanceLightStatusBars(false);

        // Move bottom navigation above the phone's navigation bar
        ViewGroup bottomNavigation = findViewById(R.id.bottomNavigation);

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
        rvPantryItems = findViewById(R.id.rvPantryItems);

        rvPantryItems.setLayoutManager(
                new LinearLayoutManager(this)
        );

        // Create database helper
        databaseHelper = new DatabaseHelper(this);

        // Get pantry items from database
        pantryItems = databaseHelper.getAllPantryItems();

        // Create adapter
        pantryAdapter = new PantryAdapter(
                this,
                pantryItems
        );

        // Connect adapter to RecyclerView
        rvPantryItems.setAdapter(pantryAdapter);

        // Add Ingredient button
        Button btnAddIngredient = findViewById(
                R.id.btnAddIngredient
        );

        btnAddIngredient.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    AddIngredientActivity.class
            );

            startActivity(intent);
        });

        // Recipes navigation button
        TextView navRecipes = findViewById(
                R.id.navRecipes
        );

        navRecipes.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    RecipesActivity.class
            );

            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Refresh pantry list when returning to this screen
        if (databaseHelper != null && pantryAdapter != null) {

            pantryItems.clear();

            pantryItems.addAll(
                    databaseHelper.getAllPantryItems()
            );

            pantryAdapter.notifyDataSetChanged();
        }
    }
}