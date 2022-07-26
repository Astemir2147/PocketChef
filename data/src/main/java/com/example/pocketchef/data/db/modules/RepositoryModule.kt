package com.example.pocketchef.data.db.modules

import com.example.pocketchef.domain.repository.LoginRepository
import com.example.pocketchef.data.db.AuthDataSource
import com.example.pocketchef.data.db.AuthDataSourceImpl
import com.example.pocketchef.data.db.repository.HomeRepositoryImpl
import com.example.pocketchef.data.db.repository.LoginRepositoryImpl
import dagger.Binds
import dagger.Module
import com.example.pocketchef.domain.repository.HomeRepository

@Module
interface RepositoryModule {

    @Binds
    fun provideHomeRepository(homeRepository: HomeRepositoryImpl): HomeRepository

    @Binds
    fun provideLoginRepository(loginRepository: LoginRepositoryImpl): LoginRepository

    @Binds
    fun provideAuthDataSource(authDataSourceImpl: AuthDataSourceImpl): AuthDataSource
}