package com.example.core.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.core.di.moduls.ContextModule
import com.example.core.di.moduls.SharedPreferenceModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        SharedPreferenceModule::class,
    ]
)
interface CoreComponent {
    fun context() : Context
    fun sharedPreference() : SharedPreferences
    fun sharedPreferenceEditor() : SharedPreferences.Editor
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): CoreComponent
    }
}