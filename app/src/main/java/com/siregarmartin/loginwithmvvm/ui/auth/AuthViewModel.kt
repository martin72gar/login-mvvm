package com.siregarmartin.loginwithmvvm.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siregarmartin.loginwithmvvm.network.Resource
import com.siregarmartin.loginwithmvvm.repository.AuthRepository
import com.siregarmartin.loginwithmvvm.responses.LoginResponse
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    fun login (email: String, password: String) = viewModelScope.launch {
        _loginResponse.value = repository.login(email, password)
    }

}