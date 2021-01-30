package com.example.signin.net

import com.example.loginapp.net.models.LoginNWModel
import com.example.loginapp.net.models.LoginUserNWModel
import com.example.signin.net.models.usermodel.UsersListNWModel
import retrofit2.Call

interface ApiHelper {
    fun loginSuccess(user: LoginUserNWModel): Call<LoginNWModel>
    fun getUsersList(page: Int, token:String): Call<UsersListNWModel>
}