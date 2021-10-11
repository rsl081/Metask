package com.s2dioapps.metask.ui.component.main.viewmodel

import com.s2dioapps.metask.data.repository.AuthRepository
import com.s2dioapps.metask.ui.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: AuthRepository) : BaseViewModel() {

//    fun getSaveToken(): String?{
//        return userRepository.getSaveToken()
//    }


//    private val _token = MutableLiveData("")
//    val token: LiveData<String> = _token
//
//    init {
//        viewModelScope.launch {
//            dataStorePreferenceRepository.getToken.collect {
//                _token.value = it
//            }
//        }
//    }


}