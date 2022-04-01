package com.george.recipes.data.remote

import androidx.room.Database
import androidx.room.RoomDatabase
import com.george.recipes.data.entities.Recipe

@Database(
    entities = [Recipe::class],
    version = 1
)
abstract class RecipeDatabase: RoomDatabase() {

    // Maybe we don't want abstract dao here but fine for now
    abstract val recipeDao: RecipeDao

    companion object {
        const val DATABASE_NAME = "recipes_db"
    }
}