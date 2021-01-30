package com.example.loginapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.loginapp.databinding.ActivityUsersBinding
import com.example.loginapp.di.ServiceLocatorImpl
import com.example.loginapp.utils.Constants
import com.example.loginapp.viewmodels.UsersViewModel
import com.example.loginapp.viewmodels.ViewModelFactory

class UsersActivity: BaseActivity() {

    private val binding by lazy { ActivityUsersBinding.inflate(layoutInflater) }
    private val serviceLocator by lazy { ServiceLocatorImpl()}
    private val usersViewModel by lazy { ViewModelFactory(serviceLocator).create(UsersViewModel::class.java)}

    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, UsersActivity::class.java)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getSharedPreferences(Constants.SH_NAME, MODE_PRIVATE).getString(Constants.SAVE_TOKEN, "")
            ?.let { usersViewModel.getUsersList(2, it) }
    }
}