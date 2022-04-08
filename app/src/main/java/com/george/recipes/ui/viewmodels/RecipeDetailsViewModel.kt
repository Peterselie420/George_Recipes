package com.george.recipes.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.george.recipes.data.remote.RecipeDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor (db: RecipeDatabase): ViewModel() {

    private val dao = db.recipeDao

    suspend fun getRecipeById(id: Long) = dao.getRecipeById(id)

}