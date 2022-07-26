package com.example.pocketchef.data.db.repository


import com.example.pocketchef.domain.repository.LoginRepository
import com.example.core.model.Cookie
import com.example.pocketchef.data.db.AuthDataSource
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
) : LoginRepository {

    override suspend fun saveCookieFromPreferences(cookie: Cookie) {
        authDataSource.saveCookie(cookie)
    }
}