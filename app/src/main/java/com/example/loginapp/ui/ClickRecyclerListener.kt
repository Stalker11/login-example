package com.example.loginapp.ui

import com.example.signin.net.models.usermodel.UserNWModel
//TODO Analog function in adapter constructor
interface ClickRecyclerListener {
    fun onItemClick(model: UserNWModel)
}