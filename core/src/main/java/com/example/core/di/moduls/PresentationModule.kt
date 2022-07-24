package com.example.core.di.moduls

import com.example.core.validation.Validator
import dagger.Module

@Module
class PresentationModule {

    fun provideValidator(): Validator {
        return Validator()
    }
}