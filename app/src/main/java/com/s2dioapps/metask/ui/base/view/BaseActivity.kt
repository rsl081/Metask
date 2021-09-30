package com.s2dioapps.metask.ui.base.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.s2dioapps.metask.ui.base.viewmodel.BaseViewModel
import java.text.SimpleDateFormat
import java.util.*

abstract class BaseActivity: AppCompatActivity() {

    abstract fun observeViewModel()
    protected abstract fun initViewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        observeViewModel()
    }

}