package com.george.recipes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.george.recipes.data.entities.Recipe
import com.george.recipes.databinding.ListItemRecipeBinding

class RecipeAdapter(private val onItemClick: (Recipe) -> Unit):
    ListAdapter<Recipe, RecipeAdapter.RecipeViewHolder>(RecipeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            ListItemRecipeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onItemClick = { position ->
                val recipe = getItem(position)
                if (recipe != null) onItemClick(recipe)
            }
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RecipeViewHolder(
        private val binding: ListItemRecipeBinding,
        private val onItemClick: (Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: Recipe) {
            val position = adapterPosition
            binding.apply {
                // Doing this here is cancer but works for now
                root.setOnClickListener {
                    if (position != RecyclerView.NO_POSITION) onItemClick(position)
                }
                this.recipe = recipe
                executePendingBindings()
            }
        }
    }
}

private class RecipeDiffCallback : DiffUtil.ItemCallback<Recipe>() {

    override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem == newItem
    }
}