package Interactor

import com.example.pocketchef.data.db.model.Cookie

interface Interactor {
    suspend fun checkIfAuthentificated(): Boolean
    suspend fun saveCookieFromPreferences(cookie: Cookie)
}