package com.s2dioapps.metask.ui.component.tasktoday.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.s2dioapps.metask.data.model.task.TaskItem
import com.s2dioapps.metask.databinding.TaskItemBinding

class TaskListItemAdapter (private val fragment: Fragment,
                           private var list: MutableList<TaskItem>
):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: TaskItemBinding =
            TaskItemBinding.inflate(LayoutInflater.from(fragment.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]

        if(holder is ViewHolder){
            val user = model.assignee
            val createdBy = model.createdBy
//
//            holder.itemView.tv_name_task_item.text = model.name
//            holder.itemView.tv_description_task_item.text = model.description
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: TaskItemBinding) : RecyclerView.ViewHolder(view.root)

}