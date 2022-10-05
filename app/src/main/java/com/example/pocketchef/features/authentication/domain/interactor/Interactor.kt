package com.example.pocketchef.features.authentication.domain.interactor

import com.example.pocketchef.features.authentication.data.model.Cookie

interface Interactor {
    suspend fun checkIfAuthentificated(): Boolean
    suspend fun saveCookieFromPreferences(cookie: Cookie)
}