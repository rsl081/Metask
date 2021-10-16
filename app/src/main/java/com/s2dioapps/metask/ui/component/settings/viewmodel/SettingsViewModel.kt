package com.s2dioapps.metask.ui.component.settings.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.s2dioapps.metask.utils.Constant

class SettingsViewModel : ViewModel() {

    fun signOut()
    {
        Constant.MSHAREDPREFERENCES.edit().clear().commit()
    }

}