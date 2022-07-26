package com.example.pocketchef.data.db

import android.content.SharedPreferences
import com.example.core.model.Cookie
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val sharedPreference: SharedPreferences,
    private val sharedPreferenceEditor: SharedPreferences.Editor
) : AuthDataSource {
    override suspend fun saveCookie(cookie: Cookie) {

        sharedPreference.edit()
            .putString(USER_MAIL_KEY, cookie.userMail)
            .putString(USER_PASSWORD_KEY, cookie.userPassword)
            .apply()
    }

    override suspend fun getCookie(): Cookie {
        val mail = sharedPreference.getString(USER_MAIL_KEY, String()).orEmpty()
        val password = sharedPreference.getString(USER_PASSWORD_KEY, String()).orEmpty()
        val name = sharedPreference.getString(USER_NAME, null).orEmpty()
        return Cookie(mail, password, name)
    }

    companion object {
        private const val USER_NAME = "userName"
        private const val USER_MAIL_KEY = "userMail"
        private const val USER_PASSWORD_KEY = "userPassword"
    }
}