package com.s2dioapps.metask.data.repository

import com.s2dioapps.metask.data.api.LoginApi
import com.s2dioapps.metask.data.model.user.User
import com.s2dioapps.metask.data.network.RetrofitApiService
import com.s2dioapps.metask.utils.Constant
import okhttp3.ResponseBody
import retrofit2.Call
import javax.inject.Inject


class LoginRepositoryImpl @Inject constructor(): LoginApi{

    override fun getUserInfo(): Call<User>? =
        Constant.MSHAREDPREFERENCES.getString(Constant.TOKEN, "")?.let {
            RetrofitApiService().getUserServiceHeaderAuth(
                it
            )
        }?.getUserInfo()

    override suspend fun logout(): ResponseBody {
        TODO("Not yet implemented")
    }

}

//fun getUserInfo() : Call<User>? = loginApi.getUserInfo()