package com.example.pocketchef.presentation.ui.di

import com.example.core.di.CoreComponent
import com.example.core.di.scope.FeatureScope
import com.example.pocketchef.presentation.ui.authentication.LoginFragment
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [LoginModule::class, ViewModelModule::class]
)
interface PresentationComponent {
    fun inject(loginFragment: LoginFragment)
}