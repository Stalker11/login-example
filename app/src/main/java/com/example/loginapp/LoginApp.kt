package com.example.loginapp

import android.app.Application
import com.facebook.stetho.Stetho

class LoginApp:Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Stetho.initializeWithDefaults(this)
        }
    }
}