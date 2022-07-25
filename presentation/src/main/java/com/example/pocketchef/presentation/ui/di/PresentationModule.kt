package com.example.pocketchef.presentation.ui.di

import com.example.pocketchef.data.db.validation.Validator
import dagger.Module

@Module
class PresentationModule {

    fun provideValidator(): Validator {
        return Validator()
    }
}