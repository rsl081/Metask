package com.s2dioapps.metask.data.network

import com.s2dioapps.metask.data.api.LoginApi
import com.s2dioapps.metask.data.api.OrganizationApi
import com.s2dioapps.metask.data.api.TaskApi
import com.s2dioapps.metask.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiService {

    //private const val BASE_URL = "https://api.coursera.org/api/businesses.v1/"
    fun getUserServiceHeaderAuth(accessToken: String): LoginApi {
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

    fun getTaskServiceHeader(accessToken: String): TaskApi {
        val client = OkHttpClient.Builder()
            .addInterceptor(OAuthInterceptor("Bearer", accessToken))
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.BASE_URL)
            .client(client)
            .build()

        return retrofit.create(TaskApi::class.java)
    }

    fun getMembersServiceHeader(accessToken: String): OrganizationApi {
        val client = OkHttpClient.Builder()
            .addInterceptor(OAuthInterceptor("Bearer", accessToken))
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.BASE_URL)
            .client(client)
            .build()

        return retrofit.create(OrganizationApi::class.java)
    }

}