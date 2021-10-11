package com.s2dioapps.metask.data.repository

import com.s2dioapps.metask.data.api.UserApi

class UserRepository(
    private val api: UserApi
) : BaseRepository(api) {

    suspend fun getUser() = safeApiCall { api.getUser() }

}