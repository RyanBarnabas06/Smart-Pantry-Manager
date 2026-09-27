package com.example.smartpantry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.smartpantry.models.PantryItem;
import com.example.smartpantry.models.Recipe;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SmartPantry.db";

    // Database version increased because we are adding recipe tables
    private static final int DATABASE_VERSION = 2;

    // PANTRY TABLE

    private static final String TABLE_PANTRY = "pantry_items";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_QUANTITY = "quantity";
    private static final String COLUMN_UNIT = "unit";
    private static final String COLUMN_EXPIRY_DATE = "expiry_date";

    // RECIPES TABLE

    private static final String TABLE_RECIPES = "recipes";

    private static final String COLUMN_RECIPE_ID = "id";
    private static final String COLUMN_RECIPE_NAME = "name";
    private static final String COLUMN_RECIPE_DESCRIPTION = "description";
    private static final String COLUMN_RECIPE_METHOD = "method";

    // RECIPE INGREDIENTS TABLE

    private static final String TABLE_RECIPE_INGREDIENTS =
            "recipe_ingredients";

    private static final String COLUMN_INGREDIENT_ID =
            "id";

    private static final String COLUMN_RECIPE_ID_FK =
            "recipe_id";

    private static final String COLUMN_INGREDIENT_NAME =
            "ingredient_name";

    private static final String COLUMN_INGREDIENT_QUANTITY =
            "quantity";

    private static final String COLUMN_INGREDIENT_UNIT =
            "unit";

    // CONSTRUCTOR

    public DatabaseHelper(Context context) {
        super(
                context,
                DATABASE_NAME,
                null,
                DATABASE_VERSION
        );
    }

    // DATABASE CREATION

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create pantry table
        createPantryTable(db);

        // Create recipe tables
        createRecipeTables(db);

        // Add the initial recipe collection
        seedRecipes(db);
    }

    // DATABASE UPGRADE

    @Override
    public void onUpgrade(
            SQLiteDatabase db,
            int oldVersion,
            int newVersion
    ) {

        if (oldVersion < 2) {

            createRecipeTables(db);

            seedRecipes(db);
        }
    }

    // CREATE PANTRY TABLE

    private void createPantryTable(SQLiteDatabase db) {

        String createTable =
                "CREATE TABLE " + TABLE_PANTRY + " (" +

                        COLUMN_ID +
                        " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                        COLUMN_NAME +
                        " TEXT NOT NULL, " +

                        COLUMN_QUANTITY +
                        " REAL NOT NULL, " +

                        COLUMN_UNIT +
                        " TEXT NOT NULL, " +

                        COLUMN_EXPIRY_DATE +
                        " TEXT NOT NULL)";

        db.execSQL(createTable);
    }

    // CREATE RECIPE TABLES

    private void createRecipeTables(SQLiteDatabase db) {

        // Recipes table
        String createRecipesTable =
                "CREATE TABLE " + TABLE_RECIPES + " (" +

                        COLUMN_RECIPE_ID +
                        " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                        COLUMN_RECIPE_NAME +
                        " TEXT NOT NULL UNIQUE, " +

                        COLUMN_RECIPE_DESCRIPTION +
                        " TEXT NOT NULL, " +

                        COLUMN_RECIPE_METHOD +
                        " TEXT NOT NULL)";

        db.execSQL(createRecipesTable);

        // Recipe ingredients table
        String createRecipeIngredientsTable =
                "CREATE TABLE " +
                        TABLE_RECIPE_INGREDIENTS + " (" +

                        COLUMN_INGREDIENT_ID +
                        " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                        COLUMN_RECIPE_ID_FK +
                        " INTEGER NOT NULL, " +

                        COLUMN_INGREDIENT_NAME +
                        " TEXT NOT NULL, " +

                        COLUMN_INGREDIENT_QUANTITY +
                        " REAL NOT NULL, " +

                        COLUMN_INGREDIENT_UNIT +
                        " TEXT NOT NULL, " +

                        "FOREIGN KEY (" +
                        COLUMN_RECIPE_ID_FK +
                        ") REFERENCES " +
                        TABLE_RECIPES +
                        "(" +
                        COLUMN_RECIPE_ID +
                        "))";

        db.execSQL(createRecipeIngredientsTable);
    }

    // PANTRY CRUD

    // CREATE - Add a new pantry item
    public long addPantryItem(PantryItem item) {

        SQLiteDatabase db =
                this.getWritableDatabase();

        ContentValues values =
                new ContentValues();

        values.put(
                COLUMN_NAME,
                item.getName()
        );

        values.put(
                COLUMN_QUANTITY,
                item.getQuantity()
        );

        values.put(
                COLUMN_UNIT,
                item.getUnit()
        );

        values.put(
                COLUMN_EXPIRY_DATE,
                item.getExpiryDate()
        );

        return db.insert(
                TABLE_PANTRY,
                null,
                values
        );
    }

    // READ - Get all pantry items
    public ArrayList<PantryItem> getAllPantryItems() {

        ArrayList<PantryItem> pantryItems =
                new ArrayList<>();

        SQLiteDatabase db =
                this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_PANTRY,
                null,
                null,
                null,
                null,
                null,
                COLUMN_NAME + " ASC"
        );

        if (cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(
                        cursor.getColumnIndexOrThrow(
                                COLUMN_ID
                        )
                );

                String name = cursor.getString(
                        cursor.getColumnIndexOrThrow(
                                COLUMN_NAME
                        )
                );

                double quantity = cursor.getDouble(
                        cursor.getColumnIndexOrThrow(
                                COLUMN_QUANTITY
                        )
                );

                String unit = cursor.getString(
                        cursor.getColumnIndexOrThrow(
                                COLUMN_UNIT
                        )
                );

                String expiryDate = cursor.getString(
                        cursor.getColumnIndexOrThrow(
                                COLUMN_EXPIRY_DATE
                        )
                );

                PantryItem item =
                        new PantryItem(
                                id,
                                name,
                                quantity,
                                unit,
                                expiryDate
                        );

                pantryItems.add(item);

            } while (cursor.moveToNext());
        }

        cursor.close();

        return pantryItems;
    }

    // UPDATE - Update an existing pantry item
    public int updatePantryItem(
            PantryItem item
    ) {

        SQLiteDatabase db =
                this.getWritableDatabase();

        ContentValues values =
                new ContentValues();

        values.put(
                COLUMN_NAME,
                item.getName()
        );

        values.put(
                COLUMN_QUANTITY,
                item.getQuantity()
        );

        values.put(
                COLUMN_UNIT,
                item.getUnit()
        );

        values.put(
                COLUMN_EXPIRY_DATE,
                item.getExpiryDate()
        );

        return db.update(
                TABLE_PANTRY,
                values,
                COLUMN_ID + " = ?",
                new String[]{
                        String.valueOf(
                                item.getId()
                        )
                }
        );
    }

    // DELETE - Delete a pantry item
    public int deletePantryItem(int id) {

        SQLiteDatabase db =
                this.getWritableDatabase();

        return db.delete(
                TABLE_PANTRY,
                COLUMN_ID + " = ?",
                new String[]{
                        String.valueOf(id)
                }
        );
    }

    // RECIPE DATABASE

    // Add a recipe and all of its ingredients
    private void insertRecipe(
            SQLiteDatabase db,
            Recipe recipe
    ) {

        ContentValues recipeValues =
                new ContentValues();

        recipeValues.put(
                COLUMN_RECIPE_NAME,
                recipe.getName()
        );

        recipeValues.put(
                COLUMN_RECIPE_DESCRIPTION,
                recipe.getDescription()
        );

        recipeValues.put(
                COLUMN_RECIPE_METHOD,
                recipe.getMethod()
        );

        long recipeId =
                db.insert(
                        TABLE_RECIPES,
                        null,
                        recipeValues
                );

        if (recipeId == -1) {
            return;
        }

        // Add each required ingredient
        for (PantryItem ingredient :
                recipe.getRequiredIngredients()) {

            ContentValues ingredientValues =
                    new ContentValues();

            ingredientValues.put(
                    COLUMN_RECIPE_ID_FK,
                    recipeId
            );

            ingredientValues.put(
                    COLUMN_INGREDIENT_NAME,
                    ingredient.getName()
            );

            ingredientValues.put(
                    COLUMN_INGREDIENT_QUANTITY,
                    ingredient.getQuantity()
            );

            ingredientValues.put(
                    COLUMN_INGREDIENT_UNIT,
                    ingredient.getUnit()
            );

            db.insert(
                    TABLE_RECIPE_INGREDIENTS,
                    null,
                    ingredientValues
            );
        }
    }

    // Seed the initial recipe collection
    private void seedRecipes(SQLiteDatabase db) {

        ArrayList<Recipe> recipes =
                RecipeData.getRecipes();

        db.beginTransaction();

        try {

            for (Recipe recipe : recipes) {

                insertRecipe(
                        db,
                        recipe
                );
            }

            db.setTransactionSuccessful();

        } finally {

            db.endTransaction();
        }
    }

    // READ - Get all recipes from SQLite
    public ArrayList<Recipe> getAllRecipes() {

        ArrayList<Recipe> recipes =
                new ArrayList<>();

        SQLiteDatabase db =
                this.getReadableDatabase();

        Cursor recipeCursor = db.query(
                TABLE_RECIPES,
                null,
                null,
                null,
                null,
                null,
                COLUMN_RECIPE_NAME + " ASC"
        );

        if (recipeCursor.moveToFirst()) {

            do {

                int recipeId =
                        recipeCursor.getInt(
                                recipeCursor
                                        .getColumnIndexOrThrow(
                                                COLUMN_RECIPE_ID
                                        )
                        );

                String name =
                        recipeCursor.getString(
                                recipeCursor
                                        .getColumnIndexOrThrow(
                                                COLUMN_RECIPE_NAME
                                        )
                        );

                String description =
                        recipeCursor.getString(
                                recipeCursor
                                        .getColumnIndexOrThrow(
                                                COLUMN_RECIPE_DESCRIPTION
                                        )
                        );

                String method =
                        recipeCursor.getString(
                                recipeCursor
                                        .getColumnIndexOrThrow(
                                                COLUMN_RECIPE_METHOD
                                        )
                        );

                ArrayList<PantryItem>
                        requiredIngredients =
                        getRecipeIngredients(
                                db,
                                recipeId
                        );

                Recipe recipe =
                        new Recipe(
                                name,
                                description,
                                method,
                                requiredIngredients
                        );

                recipes.add(recipe);

            } while (recipeCursor.moveToNext());
        }

        recipeCursor.close();

        return recipes;
    }

    // Get ingredients belonging to a recipe
    private ArrayList<PantryItem>
    getRecipeIngredients(
            SQLiteDatabase db,
            int recipeId
    ) {

        ArrayList<PantryItem>
                ingredients =
                new ArrayList<>();

        Cursor cursor = db.query(
                TABLE_RECIPE_INGREDIENTS,
                null,
                COLUMN_RECIPE_ID_FK + " = ?",
                new String[]{
                        String.valueOf(recipeId)
                },
                null,
                null,
                COLUMN_INGREDIENT_ID + " ASC"
        );

        if (cursor.moveToFirst()) {

            do {

                String name =
                        cursor.getString(
                                cursor
                                        .getColumnIndexOrThrow(
                                                COLUMN_INGREDIENT_NAME
                                        )
                        );

                double quantity =
                        cursor.getDouble(
                                cursor
                                        .getColumnIndexOrThrow(
                                                COLUMN_INGREDIENT_QUANTITY
                                        )
                        );

                String unit =
                        cursor.getString(
                                cursor
                                        .getColumnIndexOrThrow(
                                                COLUMN_INGREDIENT_UNIT
                                        )
                        );

                PantryItem ingredient =
                        new PantryItem(
                                name,
                                quantity,
                                unit,
                                ""
                        );

                ingredients.add(
                        ingredient
                );

            } while (cursor.moveToNext());
        }

        cursor.close();

        return ingredients;
    }
}