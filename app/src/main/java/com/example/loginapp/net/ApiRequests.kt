package com.example.loginapp.net

import com.example.loginapp.net.models.LoginNWModel
import com.example.loginapp.net.models.LoginUserNWModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiRequests {
    @POST("/api/login")
    fun login(@Body body: LoginUserNWModel): Call<LoginNWModel>
}