package com.example.signin.net.models.usermodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserNWModel(
    @SerializedName("id")
    @Expose
    val userId: Int,
    @SerializedName("email")
    @Expose
    val userEmail: String,
    @SerializedName("first_name")
    @Expose
    val firstName: String,
    @SerializedName("last_name")
    @Expose
    val secondName: String,
    @SerializedName("avatar")
    @Expose
    val userAvatar: String,
)
