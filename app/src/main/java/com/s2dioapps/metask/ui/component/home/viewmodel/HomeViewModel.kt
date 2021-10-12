package com.s2dioapps.metask.ui.component.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s2dioapps.metask.data.api.LoginApi
import com.s2dioapps.metask.data.model.user.User
import com.s2dioapps.metask.data.network.RetrofitApiService
import com.s2dioapps.metask.utils.Constant
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Retrofit

class HomeViewModel : ViewModel() {

    fun loginResponseCall() : Call<User>? =
      Constant.MSHAREDPREFERENCES.getString(Constant.TOKEN, "")?.let {
          RetrofitApiService().getUserServiceHeader(
            it
          )
      }?.getUserInfo()
    //fun loginResponseCall(): String = RetrofitApiService.create(Constant.MSHAREDPREFERENCES.getString(Constant.TOKEN, "")
}