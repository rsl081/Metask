package com.s2dioapps.metask.data.api

import com.s2dioapps.metask.data.model.login.LoginResponse
import com.s2dioapps.metask.data.model.user.User
import dagger.Module
import dagger.Provides
import retrofit2.Call
import retrofit2.http.*
import javax.inject.Inject
import javax.inject.Singleton

interface LoginApi : BaseApi {

    @GET("userinfo")
    fun getUserInfo(): Call<User>?

}