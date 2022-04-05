package com.george.recipes.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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
                //TODO actually navigate to details fragment instead of showing Snackbar
                Timber.d("Navigate to Details fragment with recipe param")
                Snackbar.make(binding.root, "Recipe ${(recipe.id?.minus(1))} clicked",
                    Snackbar.LENGTH_LONG).show()
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