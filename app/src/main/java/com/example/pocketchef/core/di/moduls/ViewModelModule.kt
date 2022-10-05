package com.example.pocketchef.core.di.moduls

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pocketchef.core.di.ViewModelFactory
import com.example.pocketchef.core.di.ViewModelKey
import com.example.pocketchef.features.authentication.presentation.LoginViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun providesPostsViewModel(viewModel: LoginViewModel): ViewModel
}