package com.george.recipes.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenResumed
import androidx.navigation.fragment.navArgs
import com.george.recipes.R
import com.george.recipes.data.entities.Recipe
import com.george.recipes.databinding.FragmentRecipeDetailsBinding
import com.george.recipes.ui.viewmodels.RecipeDetailsViewModel
import com.george.recipes.ui.viewmodels.RecipeListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeDetailsFragment: Fragment(R.layout.fragment_recipe_details) {

    private val args: RecipeDetailsFragmentArgs by navArgs()
    private val recipeDetailsViewModel: RecipeDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentRecipeDetailsBinding.bind(view)
        binding.apply {
            lifecycleScope.launchWhenResumed {
                val recipe = recipeDetailsViewModel.getRecipeById(args.recipeId)
                binding.recipe = recipe
            }
        }
    }
}