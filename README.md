# Smart Pantry Manager

Smart Pantry Manager is a Java-based Android application developed for the Mobile App Development 700 practical assignment.

The application helps users manage the ingredients available in their pantry and suggests recipes that can be prepared using those ingredients. Recipes are only suggested when the user has every required ingredient in the required quantity.

## Features

- Add pantry ingredients
- Edit existing pantry ingredients
- Delete pantry ingredients
- View all current pantry ingredients
- Store ingredient quantities, units and expiry dates
- Validate pantry information before saving
- Store and retrieve pantry data using SQLite
- Suggest recipes based strictly on available pantry ingredients
- Check required ingredient quantities
- Handle simple singular and plural ingredient names
- View full recipe details
- View required ingredients and quantities for all available recipes
- View recipe preparation methods
- Provide feedback when no recipes match the current pantry
- Navigate between Pantry, Recipes and Settings screens

## Technology Used

- Java
- Android Studio
- XML layouts
- SQLite
- SQLiteOpenHelper
- RecyclerView
- Custom RecyclerView Adapters
- Android Activities and Intents

## Database

SQLite was selected as the database for this application because it provides local, persistent storage directly on the Android device. It is suitable for the Smart Pantry Manager because the application does not require cloud synchronisation or an internet connection to store pantry information.

SQLite also supports the Create, Read, Update and Delete (CRUD) operations required by the application. Pantry data remains available after the application is closed and reopened.

The database contains tables for:

- Pantry items
- Recipes
- Recipe ingredients

## Recipe Matching

The application uses strict recipe matching.

A recipe is only displayed in the Suggested Recipes screen when every ingredient required by the recipe is available in the user's pantry in at least the required quantity.

Recipes are not suggested when:

- An ingredient is missing
- The available quantity is insufficient
- The required unit does not match
- Only some of the required ingredients are available

The application also handles simple singular and plural ingredient names, such as "potato" and "potatoes".

## Project Structure

The main components of the application include:

- `MainActivity` - displays the pantry list
- `AddIngredientActivity` - adds and edits pantry ingredients
- `RecipesActivity` - displays recipes that can currently be prepared
- `RecipeGuideActivity` - displays the complete recipe collection
- `RecipeDetailActivity` - displays the ingredients and preparation method for a recipe
- `SettingsActivity` - displays application settings and information
- `DatabaseHelper` - manages the SQLite database and CRUD operations
- `PantryAdapter` - displays pantry items in the RecyclerView
- `RecipeAdapter` - displays suggested recipes
- `RecipeGuideAdapter` - displays all available recipes
- `RecipeMatcher` - performs the strict recipe matching logic

## How to Run the Application

### Requirements

- Android Studio
- Android SDK
- A physical Android device or Android emulator
- USB debugging enabled when using a physical Android device

### Steps

1. Clone or download the Smart Pantry Manager project from the GitHub repository.
2. Open the project in Android Studio.
3. Allow Android Studio to synchronise the Gradle project.
4. Connect an Android device with USB debugging enabled, or start an Android emulator.
5. Select the `app` run configuration.
6. Select the connected Android device.
7. Click the Run button in Android Studio.
8. The Smart Pantry Manager application will be installed and launched on the device.

## GitHub

The project is maintained using Git version control and is hosted in a public GitHub repository.

The repository contains the incremental development history of the application, including the implementation of the database, pantry management, recipe matching, recipe screens and navigation.
