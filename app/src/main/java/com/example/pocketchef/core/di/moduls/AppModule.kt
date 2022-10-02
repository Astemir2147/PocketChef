package com.example.pocketchef.core.di.moduls

import android.content.Context
import com.example.pocketchef.core.di.DaggerCoreComponent


import dagger.Module

@Module
class AppModule(val context: Context) {
    lateinit var coreComponent: com.example.pocketchef.core.di.CoreComponent
    fun provideContext(): Context {
        return context
    }

    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .build()
    }
}