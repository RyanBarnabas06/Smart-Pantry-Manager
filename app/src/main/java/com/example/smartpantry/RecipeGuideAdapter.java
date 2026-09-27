package com.example.smartpantry;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpantry.models.PantryItem;
import com.example.smartpantry.models.Recipe;

import java.util.ArrayList;

public class RecipeGuideAdapter
        extends RecyclerView.Adapter<RecipeGuideAdapter.RecipeGuideViewHolder> {

    private Context context;
    private ArrayList<Recipe> recipes;

    public RecipeGuideAdapter(
            Context context,
            ArrayList<Recipe> recipes
    ) {
        this.context = context;
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public RecipeGuideViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {

        View view = LayoutInflater.from(context).inflate(
                R.layout.item_recipe_guide,
                parent,
                false
        );

        return new RecipeGuideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecipeGuideViewHolder holder,
            int position
    ) {

        Recipe recipe = recipes.get(position);

        holder.tvRecipeName.setText(
                recipe.getName()
        );

        StringBuilder ingredientsText =
                new StringBuilder();

        for (PantryItem ingredient :
                recipe.getRequiredIngredients()) {

            ingredientsText.append("• ")
                    .append(ingredient.getName())
                    .append(" - ")
                    .append(ingredient.getQuantity())
                    .append(" ")
                    .append(ingredient.getUnit())
                    .append("\n");
        }

        holder.tvIngredients.setText(
                ingredientsText.toString().trim()
        );

        holder.btnViewRecipe.setOnClickListener(v -> {

            Intent intent = new Intent(
                    context,
                    RecipeDetailActivity.class
            );

            intent.putExtra(
                    "recipe_name",
                    recipe.getName()
            );

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static class RecipeGuideViewHolder
            extends RecyclerView.ViewHolder {

        TextView tvRecipeName;
        TextView tvIngredients;
        Button btnViewRecipe;

        public RecipeGuideViewHolder(
                @NonNull View itemView
        ) {

            super(itemView);

            tvRecipeName = itemView.findViewById(
                    R.id.tvGuideRecipeName
            );

            tvIngredients = itemView.findViewById(
                    R.id.tvGuideIngredients
            );

            btnViewRecipe = itemView.findViewById(
                    R.id.btnGuideViewRecipe
            );
        }
    }
}
