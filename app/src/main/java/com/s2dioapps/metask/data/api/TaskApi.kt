package com.s2dioapps.metask.data.api


import com.s2dioapps.metask.data.model.task.TaskItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TaskApi {

    @GET("Tasks")
    fun getTask(
        @Query("MyTasks") myTask: Boolean,
        @Query("ShowAll") showAll: Boolean,
        @Query("Date") myDateTask: String,
    ): Call<List<TaskItem>>?


}