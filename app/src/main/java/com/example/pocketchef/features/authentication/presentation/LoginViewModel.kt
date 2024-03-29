package com.example.pocketchef.features.authentication.presentation

import androidx.lifecycle.ViewModel
import com.example.pocketchef.features.authentication.data.validation.Validator
import com.example.pocketchef.features.authentication.data.model.AuthDateUser
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val validator: Validator
) : ViewModel() {


    fun validateFields(user: AuthDateUser): Boolean {
        return validator.validateFields(user)
    }

}