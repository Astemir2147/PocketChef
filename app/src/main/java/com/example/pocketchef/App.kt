package com.example.pocketchef

import android.app.Application
import android.content.Context
import com.example.pocketchef.core.di.DaggerCoreComponent


class App: Application() {
    lateinit var coreComponent: com.example.pocketchef.core.di.CoreComponent

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