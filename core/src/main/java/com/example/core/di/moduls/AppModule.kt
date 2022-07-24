package com.example.core.di.moduls

import android.content.Context
import com.example.core.di.CoreComponent
import com.example.core.di.DaggerCoreComponent
import dagger.Module

@Module
class AppModule(val context: Context) {
    lateinit var coreComponent: CoreComponent
    fun provideContext(): Context {
        return context
    }

    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .build()
    }
}