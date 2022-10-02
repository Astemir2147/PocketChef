package com.example.pocketchef.core.di.moduls

import com.example.pocketchef.features.authentication.data.validation.Validator
import dagger.Module

@Module
class PresentationModule {

    fun provideValidator(): Validator {
        return Validator()
    }
}