package com.example.smartpantry;

import android.content.Intent;
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

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_settings);

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

        // Pantry navigation
        TextView navPantry = findViewById(
                R.id.navPantry
        );

        navPantry.setOnClickListener(v -> {

            Intent intent = new Intent(
                    SettingsActivity.this,
                    MainActivity.class
            );

            startActivity(intent);
            finish();
        });

        // Recipes navigation
        TextView navRecipes = findViewById(
                R.id.navRecipes
        );

        navRecipes.setOnClickListener(v -> {

            Intent intent = new Intent(
                    SettingsActivity.this,
                    RecipesActivity.class
            );

            startActivity(intent);
            finish();
        });
    }
}