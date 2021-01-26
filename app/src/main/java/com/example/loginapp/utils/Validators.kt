package com.example.loginapp.utils

import android.util.Patterns
import java.util.regex.Pattern

object Validators {
    val PASSWORD_REGEX = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}"

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    //TODO API required
    fun isPasswordValid(password: String): Boolean {
        return true//Pattern.compile(PASSWORD_REGEX).matcher(password).matches()
    }
}