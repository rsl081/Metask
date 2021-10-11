package com.s2dioapps.metask.data.repository

import com.s2dioapps.metask.data.api.LoginApi
import javax.inject.Inject

class AuthRepository @Inject constructor (
    private val preferences: UserPreferences
)  {

//    suspend fun login(
//        email: String,
//        password: String
//    ) = safeApiCall {
//        api.login(email, password)
//    }

    suspend fun saveAccessTokens(accessToken: String) {
        preferences.saveAccessTokens(accessToken)
    }

}