package com.example.pocketchef.core.di

import com.example.pocketchef.core.di.moduls.LoginModule
import com.example.pocketchef.core.di.moduls.ViewModelModule
import com.example.pocketchef.core.di.scope.FeatureScope
import com.example.pocketchef.features.authentication.presentation.LoginFragment

import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [LoginModule::class, ViewModelModule::class]
)
interface PresentationComponent {
    fun inject(loginFragment: LoginFragment)
}