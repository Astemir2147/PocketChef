package com.example.pocketchef.data.db.repository

import com.example.core.model.Cookie
import com.example.pocketchef.data.db.AuthDataSourceImpl
import com.example.pocketchef.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSourceImpl
) : HomeRepository {

    override suspend fun getCookieFromPreferences(): Cookie = authDataSource.getCookie()

}