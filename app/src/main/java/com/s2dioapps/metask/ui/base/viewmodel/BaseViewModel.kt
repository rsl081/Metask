package com.s2dioapps.metask.ui.base.viewmodel

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

abstract class BaseViewModel : ViewModel(){

    fun displayCurrentDate(): String {
        val sdf = SimpleDateFormat("EEE, MMM d, yyyy")
        val calendar = Calendar.getInstance()
        val currentDate: String = sdf.format(calendar.time)

        return currentDate
    }

}