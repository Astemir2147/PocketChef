package com.example.pocketchef.domain.di

import com.example.core.di.CoreComponent
import com.example.core.di.scope.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class]
)
interface DomainComponent {
    // fun inject(loginFragment: LoginFragment)
}