package com.example.signin.net.models.usermodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UsersListNWModel(
    @SerializedName("page")
    @Expose
    val currentPage: Int,
    @SerializedName("per_page")
    @Expose
    val usersOnPage: Int,
    @SerializedName("total_pages")
    @Expose
    val totalPages: Int,
    @SerializedName("data")
    @Expose
    val users: MutableList<UserNWModel>,
    @SerializedName("support")
    @Expose
    val support: SupportNWModel
)