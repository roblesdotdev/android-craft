package com.roblesdotdev.mvvmlogin.login.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roblesdotdev.mvvmlogin.core.ui.components.AppTextField
import com.roblesdotdev.mvvmlogin.ui.theme.MVVMLoginTheme

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel()
) {
    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        EmailField(
            state = state.value,
            onEmailChange = viewModel::onEmailChange,
        )
        Spacer(modifier = Modifier.height(16.dp))
        PasswordField(
            state = state.value,
            onPasswordChange = viewModel::onPasswordChange,
        )
        Spacer(modifier = Modifier.height(16.dp))
        LoginButton(state = state.value, onLoginClick = viewModel::onLogin)
    }
}

@Composable
fun LoginButton(state: LoginViewState, onLoginClick: () -> Unit) {
    Button(
        onClick = { onLoginClick() },
        enabled = state.inputsEnabled,
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
        contentPadding = PaddingValues(16.dp)
    ) {
        Text("Login")
    }
}

@Composable
fun PasswordField(state: LoginViewState, onPasswordChange: (String) -> Unit) {
    AppTextField(
        text = state.credentials.password,
        onTextChanged = {
            onPasswordChange(it)
        },
        enabled = state.inputsEnabled,
        modifier = Modifier.fillMaxWidth(),
        placeholderText = "Enter your password",
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        labelText = "Password",
        visualTransformation = PasswordVisualTransformation(),
    )
}

@Composable
fun EmailField(state: LoginViewState, onEmailChange: (String) -> Unit) {
    AppTextField(
        text = state.credentials.email,
        onTextChanged = {
            onEmailChange(it)
        },
        enabled = state.inputsEnabled,
        modifier = Modifier.fillMaxWidth(),
        placeholderText = "Enter your email",
        labelText = "Email",
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MVVMLoginTheme {
        LoginScreen()
    }
}