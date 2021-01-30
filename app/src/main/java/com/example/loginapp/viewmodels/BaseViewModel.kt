package com.example.loginapp.viewmodels

import androidx.lifecycle.ViewModel
import retrofit2.Call

abstract class BaseViewModel : ViewModel() {
    val listCalls = mutableListOf<Call<*>>()
    override fun onCleared() {
        //Do something
        listCalls.forEach {
            it.cancel()
        }
        super.onCleared()
    }
}