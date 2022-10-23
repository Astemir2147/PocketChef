package com.example.pocketchef.features.ingredients.data

import com.example.pocketchef.features.ingredients.domain.models.CurrentIngredient
import com.example.pocketchef.features.ingredients.domain.repositories.IngredientsRepository

class IngredientsRepositoryImpl : IngredientsRepository {
    override suspend fun getCurrentIngredients(): List<CurrentIngredient> {
        TODO("Not yet implemented")
    }
}