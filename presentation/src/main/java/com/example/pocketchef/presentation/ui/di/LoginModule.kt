package com.example.pocketchef.presentation.ui.di

import com.example.core.di.scope.FeatureScope
import com.example.core.validation.Validator
import dagger.Module
import dagger.Provides

@Module
class LoginModule {
    @Provides
    @FeatureScope
    fun provideValidator() = Validator()
}