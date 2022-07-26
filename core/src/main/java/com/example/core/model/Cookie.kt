package com.example.core.model

import com.example.core.extension.EMPTY

data class Cookie(
    val userName: String = String.EMPTY,
    val userMail: String,
    val userPassword: String
)