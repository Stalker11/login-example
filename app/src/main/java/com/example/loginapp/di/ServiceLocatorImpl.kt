package com.example.loginapp.di

import com.example.loginapp.net.RetrofitBuilder
import com.example.signin.net.ApiHelper
import com.example.signin.net.ApiHelperImpl

class ServiceLocatorImpl:ServiceLocator {
    private val apiHelper by lazy { ApiHelperImpl(RetrofitBuilder.apiService) }
    override fun getApiHelper(): ApiHelper = apiHelper
}