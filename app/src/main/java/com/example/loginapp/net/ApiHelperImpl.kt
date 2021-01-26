package com.example.signin.net

import com.example.loginapp.net.ApiRequests
import com.example.loginapp.net.models.LoginNWModel
import com.example.loginapp.net.models.LoginUserNWModel
import retrofit2.Call

class ApiHelperImpl(private val apiService: ApiRequests):ApiHelper {
    override fun loginSuccess(user: LoginUserNWModel): Call<LoginNWModel> = apiService.login(user)

}