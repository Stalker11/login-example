package com.example.loginapp.ui.models

data class UserModel(
    val userId: Int,
    val userEmail: String,
    val firstName: String,
    val secondName: String,
    val userAvatar: String,
    val supportUrl: String?,
    val supportDescription: String?,
    val totalPages:Int?
)
