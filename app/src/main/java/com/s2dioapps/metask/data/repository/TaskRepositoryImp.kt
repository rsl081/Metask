package com.s2dioapps.metask.data.repository

import com.s2dioapps.metask.data.api.TaskApi
import com.s2dioapps.metask.data.model.task.TaskItem
import com.s2dioapps.metask.data.network.RetrofitApiService
import com.s2dioapps.metask.utils.Constant
import retrofit2.Call
import javax.inject.Inject

class TaskRepositoryImp @Inject constructor(): TaskApi {


    override fun getTask(
        myTask: Boolean,
        showAll: Boolean,
        myDateTask: String
    ): Call<List<TaskItem>>? =
        Constant.MSHAREDPREFERENCES.getString(Constant.TOKEN, "")?.let {
            RetrofitApiService().getTaskServiceHeader(
                it
            )
        }?.getTask(myTask,showAll,myDateTask)


}