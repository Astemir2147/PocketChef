package com.example.pocketchef.data.db

import com.example.core.model.Cookie

interface AuthDataSource {
    suspend fun saveCookie(cookie: Cookie)
    suspend fun getCookie(): Cookie
}