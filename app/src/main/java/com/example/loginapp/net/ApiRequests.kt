package com.example.loginapp.net

import com.example.loginapp.net.models.LoginNWModel
import com.example.loginapp.net.models.LoginUserNWModel
import com.example.signin.net.models.usermodel.UsersListNWModel
import retrofit2.Call
import retrofit2.http.*

interface ApiRequests {
    @POST("/api/login")
    fun login(@Body body: LoginUserNWModel): Call<LoginNWModel>

    @GET("/api/users")
    fun getUsersList(@Header("Authorization") token: String,
                     @Query("page") page: Int): Call<UsersListNWModel>
}