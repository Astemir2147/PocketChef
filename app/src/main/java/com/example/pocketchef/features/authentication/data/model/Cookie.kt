package com.example.pocketchef.features.authentication.data.model

import com.example.pocketchef.core.extension.EMPTY

data class Cookie(
    val userName: String = String.EMPTY,
    val userMail: String,
    val userPassword: String
)