package com.example.pocketchef.features.ingredients.domain.usecases.implementations

import com.example.pocketchef.features.ingredients.domain.models.CurrentIngredient
import com.example.pocketchef.features.ingredients.domain.repositories.IngredientsRepository
import com.example.pocketchef.features.ingredients.domain.usecases.GetCurrentIngredientsUseCase

class GetCurrentIngredientsUseCaseImpl(
    private val ingredientsRepository: IngredientsRepository
) : GetCurrentIngredientsUseCase {
    override suspend fun execute(): List<CurrentIngredient>  = ingredientsRepository.getCurrentIngredients()
}