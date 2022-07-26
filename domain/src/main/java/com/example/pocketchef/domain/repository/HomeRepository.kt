package com.example.pocketchef.domain.repository

import com.example.core.model.Cookie

interface HomeRepository {
    suspend fun getCookieFromPreferences(): Cookie

}
