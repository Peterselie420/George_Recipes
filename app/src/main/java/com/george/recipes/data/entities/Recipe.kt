package com.george.recipes.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val title: String,
    val author: String,
    val rating: Int
) {
    override fun toString(): String {
        return title
    }
}