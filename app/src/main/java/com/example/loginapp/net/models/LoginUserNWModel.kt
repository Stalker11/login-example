package com.example.loginapp.net.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginUserNWModel(
    @SerializedName("email")
    @Expose(deserialize = false)
    val email: String,
    @SerializedName("password")
    @Expose(deserialize = false)
    val password: String
)
