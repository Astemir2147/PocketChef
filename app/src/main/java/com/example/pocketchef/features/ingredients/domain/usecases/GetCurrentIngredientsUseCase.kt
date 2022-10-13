package com.example.pocketchef.features.ingredients.domain.usecases

import com.example.pocketchef.features.ingredients.domain.models.CurrentIngredient

interface GetCurrentIngredientsUseCase {
    suspend fun execute(): List<CurrentIngredient>
}