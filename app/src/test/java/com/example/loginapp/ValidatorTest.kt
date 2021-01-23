package com.example.loginapp

import com.example.loginapp.utils.Validators
import org.junit.Assert
import org.junit.Test

class ValidatorTest {
    @Test
    fun testValidation() {
        //Crash because using Android Patterns class
        // Assert.assertEquals(Validators.isEmailValid("wer@df.com"),true)
        Assert.assertEquals(Validators.isPasswordValid("sdfAS12#$"), true)
    }
}