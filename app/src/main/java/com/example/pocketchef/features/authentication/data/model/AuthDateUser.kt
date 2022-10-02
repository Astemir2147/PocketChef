package com.example.pocketchef.features.authentication.data.model

import com.example.pocketchef.core.extension.EMPTY

class AuthDateUser(
    val email: String = String.EMPTY,
    val password: String = String.EMPTY,
    val userName: String = String.EMPTY
)

fun AuthDateUser.authDateUserToCookie() = Cookie(userName = userName, userMail = email, userPassword = password)
