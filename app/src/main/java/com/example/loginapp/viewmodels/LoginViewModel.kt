package com.example.loginapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.loginapp.di.ServiceLocator
import com.example.loginapp.net.models.LoginNWModel
import com.example.loginapp.net.models.LoginUserNWModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executors

class LoginViewModel(val serviceLocator: ServiceLocator) : BaseViewModel() {
    private val TAG = LoginViewModel::class.java.simpleName
    val loginLiveData by lazy { MutableLiveData<LoginNWModel>() }

    fun login(userNWModel: LoginUserNWModel) {
        serviceLocator.getApiHelper().loginSuccess(userNWModel).enqueue(object :
            Callback<LoginNWModel> {
            override fun onResponse(call: Call<LoginNWModel>, response: Response<LoginNWModel>) {
                loginLiveData.postValue(response.body())
                Log.d(TAG, "onResponse: ${response.body()?.token}")
            }

            override fun onFailure(call: Call<LoginNWModel>, t: Throwable) {

            }

        })
        /*Executors.newFixedThreadPool(1).execute {
            serviceLocator.getApiHelper().loginSuccess().execute()
        }*/
    }
}