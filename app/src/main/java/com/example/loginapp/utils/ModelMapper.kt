package com.example.loginapp.utils

import com.example.loginapp.ui.models.UserModel
import com.example.signin.net.models.usermodel.UsersListNWModel

object ModelMapper {
    fun mapUserNWtoLocalUser(userNWModel: UsersListNWModel?): MutableList<UserModel> {
        val listOfUsers = mutableListOf<UserModel>()
        userNWModel?.users?.forEach {
            listOfUsers.add(
                UserModel(
                    userId = it.userId,
                    userEmail = it.userEmail,
                    firstName = it.firstName,
                    secondName = it.secondName,
                    userAvatar = it.userAvatar,
                    supportUrl = userNWModel.support.supportUrl,
                    supportDescription = userNWModel.support.supportDescription,
                    totalPages = userNWModel.totalPages
                )
            )
        }
        listOfUsers.add(UserModel(
            userId = -1,
            userEmail = "",
            firstName = "",
            secondName = "",
            userAvatar = "",
            supportUrl = userNWModel?.support?.supportUrl,
            supportDescription = userNWModel?.support?.supportDescription,
            totalPages = userNWModel?.totalPages!!
        ))
        return listOfUsers
    }
}