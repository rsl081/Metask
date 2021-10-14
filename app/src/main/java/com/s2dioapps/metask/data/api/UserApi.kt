package com.s2dioapps.metask.data.api

import com.s2dioapps.metask.data.model.login.LoginResponse
import retrofit2.http.GET

interface UserApi : BaseApi{
    @GET("user")
    suspend fun getUser(): LoginResponse
}