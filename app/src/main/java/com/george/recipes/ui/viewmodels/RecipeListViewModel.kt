package com.george.recipes.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.george.recipes.data.entities.Recipe
import com.george.recipes.data.remote.RecipeDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(db: RecipeDatabase): ViewModel() {

    private val dao = db.recipeDao

    init {
        viewModelScope.launch {
            // Testing code to make sure database contains some recipes, delete in final implementation
            val numberOfRecipes = 20
            if (dao.getRecipes().count() < numberOfRecipes) {
                Timber.d("Room database empty, adding decoy recipes")
                val recipeList = mutableListOf<Recipe>()
                for (i in 0 .. numberOfRecipes) recipeList.add(
                    Recipe(author = "Peter", title = "Recipe $i", rating = 5))
                dao.insertRecipes(recipeList)
            }
        }
    }

    suspend fun getRecipes() = dao.getRecipes()
}