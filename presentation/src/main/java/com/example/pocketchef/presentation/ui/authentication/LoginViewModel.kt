package com.example.pocketchef.presentation.ui.authentication

import androidx.lifecycle.ViewModel
import com.example.pocketchef.data.db.validation.Validator
import com.example.core.model.AuthDateUser
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val validator: Validator
) : ViewModel() {


    fun validateFields(user: AuthDateUser): Boolean {
        return validator.validateFields(user)
    }

}