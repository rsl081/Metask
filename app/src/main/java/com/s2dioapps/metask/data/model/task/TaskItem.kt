package com.s2dioapps.metask.data.model.task

import com.s2dioapps.metask.data.model.user.User

data class TaskItem (
    val id: String?,
    val name: String?,
    val description: String?,
    val createdBy: User,
    val assignee: User?,
    var date: String?,
    val dateCreated: String?,
    val isCompleted: Boolean?,
    var expand : Boolean = false
)