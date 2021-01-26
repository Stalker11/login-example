package com.example.loginapp.net.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginNWModel(@SerializedName(value = "token")
                        @Expose(serialize = true, deserialize = true) val token:String)
