package com.example.signin.net

import com.example.loginapp.net.models.LoginNWModel
import com.example.loginapp.net.models.LoginUserNWModel
import retrofit2.Call

interface ApiHelper {
    fun loginSuccess(user: LoginUserNWModel): Call<LoginNWModel>
}