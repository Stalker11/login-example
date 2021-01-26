package com.example.loginapp.net

import com.example.loginapp.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {
    private const val BASE_URL = "https://reqres.in/"
    private val loggingInterceptor = HttpLoggingInterceptor()
    private lateinit var eventHttpClient: OkHttpClient
    private lateinit var headerInterceptor: OkHttpClient

    private fun getRetrofit(): Retrofit {
        setUpInterceptor()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(eventHttpClient)
            // .client(headerInterceptor)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun setUpInterceptor() {
        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            eventHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addNetworkInterceptor(StethoInterceptor())
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()
            /*headerInterceptor = OkHttpClient.Builder().apply {
                addInterceptor(
                    Interceptor { chain ->
                        val builder = chain.request().newBuilder()
                        builder.header("X-App-Version", "1.23")
                        builder.header("X-Platform", "Android")
                        builder.header("X-Auth-Token", "sgsrager32524542afg3423")
                        return@Interceptor chain.proceed(builder.build())
                    }
                )
            }.build()*/
            //https://proandroiddev.com/headers-in-retrofit-a8d71ede2f3e
        }
    }

    val apiService: ApiRequests = getRetrofit().create(ApiRequests::class.java)

}