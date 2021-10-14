package com.s2dioapps.metask.ui.component.home.viewmodel

import androidx.lifecycle.*
import com.s2dioapps.metask.data.api.LoginApi
import com.s2dioapps.metask.data.model.user.User
import com.s2dioapps.metask.data.network.RetrofitApiService
import com.s2dioapps.metask.ui.component.home.viewmodel.HomeViewModel_Factory.create
import com.s2dioapps.metask.utils.Constant
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val loginApi: LoginApi) : ViewModel() {

    fun loginResponse(): Call<User>? = loginApi.getUserInfo()

}