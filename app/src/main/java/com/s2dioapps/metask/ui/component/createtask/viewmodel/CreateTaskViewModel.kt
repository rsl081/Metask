package com.s2dioapps.metask.ui.component.createtask.viewmodel

import androidx.lifecycle.ViewModel
import com.s2dioapps.metask.data.api.OrganizationApi
import com.s2dioapps.metask.data.model.task.TaskItem
import com.s2dioapps.metask.data.model.user.Member
import com.s2dioapps.metask.utils.Constant
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import javax.inject.Inject
import javax.security.auth.callback.Callback


@HiltViewModel
class CreateTaskViewModel @Inject constructor(private val organizationApi: OrganizationApi): ViewModel(){

    fun getMembers(): Call<List<Member>>? = organizationApi.getMembers(Constant.ORG_ID)

}