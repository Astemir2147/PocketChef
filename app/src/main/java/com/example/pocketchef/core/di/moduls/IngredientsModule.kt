package com.example.pocketchef.core.di.moduls

import com.example.pocketchef.core.di.scope.FeatureScope
import com.example.pocketchef.features.ingredients.data.IngredientsRepositoryImpl
import com.example.pocketchef.features.ingredients.domain.repositories.IngredientsRepository
import com.example.pocketchef.features.ingredients.domain.usecases.GetCurrentIngredientsUseCase
import com.example.pocketchef.features.ingredients.domain.usecases.implementations.GetCurrentIngredientsUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class IngredientsModule {

    @Provides
    @FeatureScope
    fun provideGetCurrentIngredientsUseCase(ingredientsRepository: IngredientsRepository) : GetCurrentIngredientsUseCase {
        return GetCurrentIngredientsUseCaseImpl(ingredientsRepository = ingredientsRepository)
    }

    @Provides
    @FeatureScope
    fun provideIngredientsRepository() : IngredientsRepository {
        return IngredientsRepositoryImpl()
    }
}