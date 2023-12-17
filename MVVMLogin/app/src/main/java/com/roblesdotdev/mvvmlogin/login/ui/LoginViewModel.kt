package com.roblesdotdev.mvvmlogin.login.ui

import androidx.lifecycle.ViewModel
import com.roblesdotdev.mvvmlogin.login.domain.model.Credentials
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {
    private val _state = MutableStateFlow(LoginViewState())
    val state: StateFlow<LoginViewState> = _state

    fun onEmailChange(email: String) {
        val currentCredentials = _state.value.credentials
        _state.value = LoginViewState(
            credentials = currentCredentials.withUpdatedEmail(email)
        )
    }

    fun onPasswordChange(password: String) {
        val currentCredentials = _state.value.credentials
        _state.value = LoginViewState(
            credentials = currentCredentials.withUpdatedPassword(password)
        )
    }

    fun onLogin() {
        val currentCredentials = _state.value.credentials

        _state.value = LoginViewState(
            credentials = currentCredentials,
            inputsEnabled = false,
        )
    }
}

fun Credentials.withUpdatedEmail(email: String): Credentials {
    return this.copy(email = email)
}

fun Credentials.withUpdatedPassword(password: String): Credentials {
    return this.copy(password = password)
}