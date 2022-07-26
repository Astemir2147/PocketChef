package com.example.pocketchef.data.db

import com.example.core.di.CoreComponent
import com.example.core.di.scope.FeatureScope
import com.example.pocketchef.data.db.modules.RepositoryModule
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [RepositoryModule::class]
)
interface DataComponent {
}
