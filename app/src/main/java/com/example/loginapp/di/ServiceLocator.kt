package com.example.loginapp.di

import com.example.signin.net.ApiHelper

interface ServiceLocator {
    fun getApiHelper(): ApiHelper
}