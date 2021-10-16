package com.s2dioapps.metask.ui.component.home.viewmodel

import androidx.lifecycle.*
import com.s2dioapps.metask.data.api.LoginApi
import com.s2dioapps.metask.data.api.TaskApi
import com.s2dioapps.metask.data.model.task.TaskItem
import com.s2dioapps.metask.data.model.user.User
import com.s2dioapps.metask.ui.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val loginApi: LoginApi, private val taskApi: TaskApi) : BaseViewModel() {


    fun userInfo(): Call<User>? = loginApi.getUserInfo()

    fun getTask(): Call<List<TaskItem>>? = taskApi.getTask(true,false,"2021-10-14")

}