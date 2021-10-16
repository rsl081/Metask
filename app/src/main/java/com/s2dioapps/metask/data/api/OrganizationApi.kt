package com.s2dioapps.metask.data.api

import com.s2dioapps.metask.data.model.user.Member
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OrganizationApi {

    @GET("Organization/{id}/members")
    fun getMembers(@Path("id") id: String): Call<List<Member>>?

}