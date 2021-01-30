package com.example.loginapp.viewmodels

import com.example.loginapp.di.ServiceLocator
import com.example.signin.net.models.usermodel.UsersListNWModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersViewModel(val serviceLocator: ServiceLocator) : BaseViewModel() {

    fun getUsersList(page: Int, token: String) {
        val catch = serviceLocator.getApiHelper()
            .getUsersList(page, token)
        listCalls.add(catch as Call<*>)
        catch.enqueue(object : Callback<UsersListNWModel> {
            override fun onResponse(
                call: Call<UsersListNWModel>,
                response: Response<UsersListNWModel>
            ) {

            }

            override fun onFailure(call: Call<UsersListNWModel>, t: Throwable) {

            }

        })
    }
}