package com.example.loginapp.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.loginapp.di.ServiceLocator
import com.example.loginapp.net.models.ErrorNWModel
import com.example.loginapp.ui.models.UserModel
import com.example.loginapp.utils.HttpErrorsParser
import com.example.loginapp.utils.ModelMapper
import com.example.signin.net.models.usermodel.UsersListNWModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersViewModel(val serviceLocator: ServiceLocator) : BaseViewModel() {

    val usersList by lazy { MutableLiveData<MutableList<UserModel>>() }
    val errorLiveData by lazy { MutableLiveData<ErrorNWModel>() }

    fun getUsersList(page: Int, token: String) {
        val catch = serviceLocator.getApiHelper()
            .getUsersList(page, token)
        listCalls.add(catch as Call<*>)
        catch.enqueue(object : Callback<UsersListNWModel> {
            override fun onResponse(
                call: Call<UsersListNWModel>,
                response: Response<UsersListNWModel>
            ) {
                when(response.code()){
                  200 -> usersList.postValue(ModelMapper.mapUserNWtoLocalUser(response.body()))
                  else -> errorLiveData.postValue(HttpErrorsParser.parseResponse(response))
                }
            }

            override fun onFailure(call: Call<UsersListNWModel>, t: Throwable) {
                errorLiveData.postValue(t?.message?.let { ErrorNWModel(errorCode = -1, it) })
            }

        })
    }
}