package com.example.loginapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginapp.di.ServiceLocator

class ViewModelFactory(val serviceLocator : ServiceLocator) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(serviceLocator) as T
        }
        if (modelClass.isAssignableFrom(UsersViewModel::class.java)) {
            return UsersViewModel(serviceLocator) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}