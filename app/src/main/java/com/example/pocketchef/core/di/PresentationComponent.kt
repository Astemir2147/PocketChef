package com.example.pocketchef.core.di

import com.example.pocketchef.core.di.moduls.IngredientsModule
import com.example.pocketchef.core.di.moduls.LoginModule
import com.example.pocketchef.core.di.moduls.ViewModelModule
import com.example.pocketchef.core.di.scope.FeatureScope
import com.example.pocketchef.features.authentication.presentation.LoginFragment
import com.example.pocketchef.features.ingredients.presentation.IngredientsFragment

import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [LoginModule::class, ViewModelModule::class, IngredientsModule::class]
)
interface PresentationComponent {
    fun inject(loginFragment: LoginFragment)
    fun injectIngredientsFragment(ingredientsFragment: IngredientsFragment)
}