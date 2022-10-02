package com.example.pocketchef.core.di.moduls


import com.example.pocketchef.core.di.scope.FeatureScope
import com.example.pocketchef.features.authentication.data.validation.Validator
import dagger.Module
import dagger.Provides

@Module
class LoginModule {
    @Provides
    @FeatureScope
    fun provideValidator() = Validator()
}