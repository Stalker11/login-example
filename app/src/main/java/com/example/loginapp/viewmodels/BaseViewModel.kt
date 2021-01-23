package com.example.loginapp.viewmodels

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    override fun onCleared() {
        super.onCleared()
    }
}