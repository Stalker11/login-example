package com.example.loginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.loginapp.databinding.ActivityMainBinding
import com.example.loginapp.utils.Validators
import com.example.loginapp.viewmodels.LoginViewModel
import com.example.loginapp.viewmodels.ViewModelFactory

class LoginActivity : AppCompatActivity() {

    private val loginViewModel by lazy { ViewModelFactory().create(LoginViewModel::class.java) }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
        binding.signInSocialBtn.icAppleIcon.setOnClickListener {

        }
        loginViewModel.login()
    }

    private fun initViews() {
        binding.signInBackBtn.setOnClickListener {
            onBackPressed()
        }
        binding.signInSocialBtn.icAppleIcon.setOnClickListener {
            //TODO Add SN login
        }
        binding.signInEmailEditText.setOnFocusChangeListener { v, hasFocus ->
            when (hasFocus) {
                true -> {
                    binding.signInEmailContainer.background = ContextCompat.getDrawable(
                        this,
                        R.drawable.input_text_border
                    )
                    binding.signInEmailErrorMessage.text = null
                }

                false -> isFieldsValid()
            }
        }
        binding.signInPasswordEditText.setOnFocusChangeListener { v, hasFocus ->
            when (hasFocus) {
                true -> {
                    binding.signInPasContainer.background = ContextCompat.getDrawable(
                        this,
                        R.drawable.input_text_border
                    )
                    binding.signInPasswordErrorMessage.text = null
                }
                false -> isFieldsValid()
            }
        }
        binding.signInBtn.setOnClickListener {
            isFieldsValid()
        }
    }

    private fun isFieldsValid(): Boolean {

        val isEmailValid =
            Validators.isEmailValid(binding.signInEmailEditText.text.toString().trim())
        val isPasswordValid =
            Validators.isPasswordValid(binding.signInPasswordEditText.text.toString().trim())

        if (!isEmailValid) {
            binding.signInEmailContainer.background = ContextCompat.getDrawable(
                this,
                R.drawable.input_text_error_border
            )
            binding.signInEmailErrorMessage.text = getString(R.string.wrong_email)
        }
        if (!isPasswordValid) {
            binding.signInPasContainer.background = ContextCompat.getDrawable(
                this,
                R.drawable.input_text_error_border
            )
            binding.signInPasswordErrorMessage.text = getString(R.string.wrong_password)
        }
        return isEmailValid && isPasswordValid
    }

    //TODO Add exit from to 2 clicks
    override fun onBackPressed() {
        super.onBackPressed()
    }
}