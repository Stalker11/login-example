package com.example.loginapp.utils

import com.example.loginapp.net.models.ErrorNWModel
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response

object HttpErrorsParser {
    fun parseResponse(
        response: Response<*>
    ): ErrorNWModel {
        when (response.code()) {
            400 -> return ErrorNWModel(400, parseErrorMessage(response.errorBody()))
        }
        return ErrorNWModel(-1, "Unknown exception")
    }

    private fun parseErrorMessage(errorBody: ResponseBody?): String {
        try {
            val reader = JSONObject(errorBody?.string())
            return reader.getString("error")
        } catch (e: Exception) {
            return "Format exception"
        }

    }
}