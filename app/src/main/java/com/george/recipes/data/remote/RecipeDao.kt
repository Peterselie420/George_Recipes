package com.george.recipes.data.remote

import androidx.room.*
import com.george.recipes.data.entities.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe")
    fun getRecipes(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipe WHERE id = :id")
    suspend fun getNoteById(id: Long): Recipe?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(recipe: Recipe)

    @Delete
    suspend fun deleteNote(recipe: Recipe)
}