package com.s2dioapps.metask.ui.component.login.viewmodel

import com.s2dioapps.metask.data.repository.AuthRepository
import com.s2dioapps.metask.ui.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: AuthRepository) : BaseViewModel() {

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

    suspend fun saveAccessTokens(accessToken: String) {
        repository.saveAccessTokens(accessToken)
    }

}


