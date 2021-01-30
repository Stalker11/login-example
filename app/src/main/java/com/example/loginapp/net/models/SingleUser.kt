package com.example.signin.net.models.usermodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SingleUser(
    @SerializedName("data")
    @Expose
    val userModel: UserNWModel,
    @SerializedName("support")
    @Expose
    val supportNWModel: SupportNWModel

)