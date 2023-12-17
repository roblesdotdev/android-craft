package com.roblesdotdev.mvvmlogin.login.ui

import com.roblesdotdev.mvvmlogin.login.domain.model.Credentials

data class LoginViewState(
    val credentials: Credentials = Credentials(),
    val inputsEnabled: Boolean = true,
)