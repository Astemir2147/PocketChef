package com.example.pocketchef.presentation.ui.authentication

import androidx.lifecycle.ViewModel
import com.example.core.validation.Validator
import model.AuthDateUser
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val validator: Validator
) : ViewModel() {

    fun validateFields(user: AuthDateUser): Boolean {
        var isValid = true
        if (validator.validateUsername(user.email, user.password)) {
            isValid = false
        }
        if (!validator.validateEmail(user.email)) {
            isValid = false
        }
        return isValid
    }
}