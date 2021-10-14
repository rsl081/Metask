package com.s2dioapps.metask.data.repository

import com.s2dioapps.metask.data.api.BaseApi
import com.s2dioapps.metask.data.api.SafeApiCall

abstract class BaseRepository(private val api: BaseApi) : SafeApiCall {

    suspend fun logout() = safeApiCall {
        api.logout()
    }
}