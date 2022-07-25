package com.example.pocketchef.data.db.model

import com.example.core.extension.EMPTY

class AuthDateUser(
    val email: String = String.EMPTY,
    val password: String = String.EMPTY,
    val userName: String = String.EMPTY
)

fun AuthDateUser.authDateUserToCookie() = Cookie(userName = userName, userMail = email, userPassword = password)
