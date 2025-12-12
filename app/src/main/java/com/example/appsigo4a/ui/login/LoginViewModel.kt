package com.example.appsigo4a.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appsigo4a.data.model.UserResponse
import com.example.appsigo4a.data.remote.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow<Result<UserResponse>?>(null)
    val loginState: StateFlow<Result<UserResponse>?> = _loginState

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val result = repository.login(username, password)
            _loginState.value = result
        }
    }
}