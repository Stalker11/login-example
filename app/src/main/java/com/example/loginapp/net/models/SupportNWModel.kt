package com.example.signin.net.models.usermodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SupportNWModel(
    @SerializedName("url")
    @Expose
    val supportUrl: String,
    @SerializedName("text")
    @Expose
    val supportDescription: String
)