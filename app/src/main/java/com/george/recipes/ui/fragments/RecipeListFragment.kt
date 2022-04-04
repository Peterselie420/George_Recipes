package com.george.recipes.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.george.recipes.adapters.RecipeAdapter
import com.george.recipes.databinding.FragmentRecipeBinding
import com.george.recipes.ui.viewmodels.RecipeListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment: Fragment() {

    private val recipeListViewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRecipeBinding.inflate(inflater)
        val adapter = RecipeAdapter()
        recipeListViewModel.recipes.observe(viewLifecycleOwner) { adapter.submitList(it) }
        binding.recyclerview.adapter = adapter
        return binding.root
    }
}