package com.roblesdotdev.mvvmlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.roblesdotdev.mvvmlogin.login.ui.LoginScreen
import com.roblesdotdev.mvvmlogin.ui.theme.MVVMLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMLoginTheme {
                LoginScreen()
            }
        }
    }
}
