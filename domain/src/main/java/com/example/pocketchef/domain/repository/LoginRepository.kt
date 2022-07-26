package com.example.pocketchef.domain.repository

import com.example.core.model.Cookie

interface LoginRepository {
    suspend fun saveCookieFromPreferences(cookie: Cookie)
}