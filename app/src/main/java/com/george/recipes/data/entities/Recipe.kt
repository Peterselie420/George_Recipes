package com.george.recipes.data.entities

import androidx.room.Entity

@Entity
data class Recipe(
    val id: Long,
    val title: String,
    val author: String,
    val rating: Int
) {
    override fun toString(): String {
        return title
    }
}