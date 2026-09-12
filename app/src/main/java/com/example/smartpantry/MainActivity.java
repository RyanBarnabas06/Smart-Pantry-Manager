package com.example.smartpantry;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
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
        WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView())
                .setAppearanceLightStatusBars(false);

        // Connect RecyclerView
        rvPantryItems = findViewById(R.id.rvPantryItems);

        // Set RecyclerView layout
        rvPantryItems.setLayoutManager(
                new LinearLayoutManager(this)
        );

        // Create database helper
        databaseHelper = new DatabaseHelper(this);

        // Get pantry items from database
        pantryItems = databaseHelper.getAllPantryItems();

        // Create adapter
        pantryAdapter = new PantryAdapter(this, pantryItems);

        // Connect adapter to RecyclerView
        rvPantryItems.setAdapter(pantryAdapter);

        // Add Ingredient button
        Button btnAddIngredient = findViewById(R.id.btnAddIngredient);

        btnAddIngredient.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    AddIngredientActivity.class
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