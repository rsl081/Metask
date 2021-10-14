package com.s2dioapps.metask.data.network

import com.s2dioapps.metask.data.api.LoginApi
import com.s2dioapps.metask.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiService {

    //private const val BASE_URL = "https://api.coursera.org/api/businesses.v1/"
    fun getUserServiceHeader(accessToken: String): LoginApi {
        val client = OkHttpClient.Builder()
            .addInterceptor(OAuthInterceptor("Bearer", accessToken))
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.BASE_URL_AUTH)
            .client(client)
            .build()

        return retrofit.create(LoginApi::class.java)
    }

}