package com.s2dioapps.metask.ui.component.createtask.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.s2dioapps.metask.R
import com.s2dioapps.metask.data.model.task.TaskItem
import com.s2dioapps.metask.data.model.user.Member
import com.s2dioapps.metask.data.model.user.User
import com.s2dioapps.metask.ui.component.createtask.viewmodel.CreateTaskViewModel
import com.s2dioapps.metask.ui.component.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class CreateTaskActivity : AppCompatActivity() {

    private val createTaskViewModel: CreateTaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        init()

    }

    fun init(){
        createTaskViewModel.getMembers()?.enqueue(object: Callback<List<Member>> {
            override fun onResponse(
                call: Call<List<Member>>,
                response: Response<List<Member>>
            ) {
                val members = response.body()
                Log.i("OkayNotif", members.toString())
            }
            override fun onFailure(call: Call<List<Member>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}