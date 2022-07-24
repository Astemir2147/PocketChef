package com.example.core

import android.app.Application
import android.content.Context
import com.example.core.di.CoreComponent
import com.example.core.di.DaggerCoreComponent

class App: Application() {
    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        initCoreDependencyInjection()
    }

    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .application(this)
            .build()
    }

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) = (context.applicationContext as? App)?.coreComponent
    }
}