package com.example.pocketchef.features.ingredients.domain.repositories

import com.example.pocketchef.features.ingredients.domain.models.CurrentIngredient

interface IngredientsRepository {

    suspend fun getCurrentIngredients(): List<CurrentIngredient>
}