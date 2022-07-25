package com.example.pocketchef.data.db.validation

import com.example.pocketchef.data.db.model.AuthDateUser

/**
 * Класс содержащий методы салидаии для полей ввода при регистрации
 */
class Validator {

    /**
     * Метод проверки соответствия Email шаблону xxx@xx.xx
     *
     * @param email
     */
    private fun validateEmail(email: String): Boolean = email.matches(emailRegex)

    /**
     * Метод проверки сложности пароля
     *
     * @param password
     */
    fun checkIsPasswordDifficult(password: String): Boolean = password.contains(upperCase) &&
        password.contains(lowerCase) && password.contains(numbers)

    /**
     * Метод проверки пустоты имени пользователя и пароля
     *
     * @param username
     */
    private fun checkValidateDateNotEmpty(username: String, password: String): Boolean =
        username.isNotEmpty() && password.isNotEmpty()

    fun validateFields(user: AuthDateUser): Boolean {
        return checkValidateDateNotEmpty(user.email, user.password) && validateEmail(user.email)
    }

    companion object {
        private val emailRegex = "[A-Za-z0-9_.]+@[A-Za-z0-9_.]+".toRegex()
        private val upperCase = "[A-Z]+".toRegex()
        private val lowerCase = "[a-z]+".toRegex()
        private val numbers = "[0-9]+".toRegex()
    }
}