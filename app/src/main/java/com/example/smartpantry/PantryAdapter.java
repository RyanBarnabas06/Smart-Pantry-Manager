package com.example.smartpantry;

import android.app.AlertDialog;
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

import java.util.ArrayList;

public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.PantryViewHolder> {

    private ArrayList<PantryItem> pantryItems;
    private Context context;
    private DatabaseHelper databaseHelper;

    public PantryAdapter(Context context, ArrayList<PantryItem> pantryItems) {
        this.context = context;
        this.pantryItems = pantryItems;
        this.databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public PantryViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pantry, parent, false);

        return new PantryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull PantryViewHolder holder,
            int position
    ) {

        PantryItem item = pantryItems.get(position);

        holder.tvIngredientName.setText(item.getName());

        holder.tvQuantity.setText(
                "Quantity: " + item.getQuantity() + " " + item.getUnit()
        );

        holder.tvExpiry.setText(
                "Expiry: " + item.getExpiryDate()
        );

        // Edit button
        holder.btnEdit.setOnClickListener(v -> {

            Intent intent = new Intent(
                    context,
                    AddIngredientActivity.class
            );

            intent.putExtra("ingredient_id", item.getId());
            intent.putExtra("ingredient_name", item.getName());
            intent.putExtra("ingredient_quantity", item.getQuantity());
            intent.putExtra("ingredient_unit", item.getUnit());
            intent.putExtra("ingredient_expiry", item.getExpiryDate());

            context.startActivity(intent);
        });

        // Delete button
        holder.btnDelete.setOnClickListener(v -> {

            new AlertDialog.Builder(context)
                    .setTitle("Delete Ingredient")
                    .setMessage(
                            "Are you sure you want to delete "
                                    + item.getName() + "?"
                    )
                    .setPositiveButton("Delete", (dialog, which) -> {

                        databaseHelper.deletePantryItem(item.getId());

                        pantryItems.remove(position);

                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, pantryItems.size());
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return pantryItems.size();
    }

    public static class PantryViewHolder extends RecyclerView.ViewHolder {

        TextView tvIngredientName;
        TextView tvQuantity;
        TextView tvExpiry;

        Button btnEdit;
        Button btnDelete;

        public PantryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvIngredientName = itemView.findViewById(
                    R.id.tvIngredientName
            );

            tvQuantity = itemView.findViewById(
                    R.id.tvQuantity
            );

            tvExpiry = itemView.findViewById(
                    R.id.tvExpiry
            );

            btnEdit = itemView.findViewById(
                    R.id.btnEdit
            );

            btnDelete = itemView.findViewById(
                    R.id.btnDelete
            );
        }
    }
}