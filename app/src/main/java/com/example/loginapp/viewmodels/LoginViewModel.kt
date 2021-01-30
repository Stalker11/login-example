package com.example.loginapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.loginapp.di.ServiceLocator
import com.example.loginapp.net.models.ErrorNWModel
import com.example.loginapp.net.models.LoginNWModel
import com.example.loginapp.net.models.LoginUserNWModel
import com.example.loginapp.utils.HttpErrorsParser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executors

class LoginViewModel(val serviceLocator: ServiceLocator) : BaseViewModel() {
    private val TAG = LoginViewModel::class.java.simpleName
    val loginLiveData by lazy { MutableLiveData<LoginNWModel>() }
    val errorLiveData by lazy { MutableLiveData<ErrorNWModel>() }

    fun login(userNWModel: LoginUserNWModel) {
        val catch = serviceLocator.getApiHelper().loginSuccess(userNWModel)
        listCalls.add(catch)
        catch.enqueue(object :
            Callback<LoginNWModel> {
            override fun onResponse(call: Call<LoginNWModel>, response: Response<LoginNWModel>) {
                if (response.code() == 200) {
                    loginLiveData.postValue(response.body())
                } else {
                    errorLiveData.postValue(HttpErrorsParser.parseResponse(response))
                }
                Log.d(TAG, "onResponse: ${response.body()?.token}")
            }

            override fun onFailure(call: Call<LoginNWModel>, t: Throwable) {
                errorLiveData.postValue(t?.message?.let { ErrorNWModel(errorCode = -1, it) })
            }

        })
        /*Executors.newFixedThreadPool(1).execute {
            serviceLocator.getApiHelper().loginSuccess().execute()
        }*/
    }
}