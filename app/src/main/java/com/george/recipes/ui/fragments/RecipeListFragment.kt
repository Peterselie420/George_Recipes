package com.george.recipes.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.george.recipes.R
import com.george.recipes.adapters.RecipeAdapter
import com.george.recipes.databinding.FragmentRecipeListBinding
import com.george.recipes.ui.viewmodels.RecipeListViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class RecipeListFragment: Fragment(R.layout.fragment_recipe_list) {

    private val recipeListViewModel: RecipeListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentRecipeListBinding.bind(view)
        val adapter = RecipeAdapter(
            onItemClick = { recipe ->
                // Null should not be possible here
                if (recipe.id == null) return@RecipeAdapter
                val action = RecipeListFragmentDirections.actionNavRecipesToNavDetails(recipe.id)
                findNavController().navigate(action)
            }
        )
        binding.apply {
            recyclerview.apply {
                this.adapter= adapter
                setHasFixedSize(true)
            }
            lifecycleScope.launchWhenResumed {
                adapter.submitList(recipeListViewModel.getRecipes())
            }
        }
    }
}