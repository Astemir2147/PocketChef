package com.example.core.di.moduls

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class SharedPreferenceModule {

    @Provides
    @Singleton
    fun providesPreference(context: Context): SharedPreferences = context.getSharedPreferences(
        PREF_NAME, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun providesSharedPreference(sharedPreferences: SharedPreferences): SharedPreferences.Editor = sharedPreferences.edit()

    companion object {
        const val PREF_NAME = "app_prefs"
    }
}