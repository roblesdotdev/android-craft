package com.roblesdotdev.jetnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(Screen.MainScreen.route) {
            val message = "This is my awesome message"
            Column {
                Text(text = "Hello, World")
                Button(onClick = {
                    navController.navigate(Screen.DetailScreen.withArgs(message))
                }) {
                    Text(text = "Go to detail")
                }
            }
        }
        composable(
            route = "${Screen.DetailScreen.route}/{message}",
            arguments = listOf(
                navArgument("message") {
                    type = NavType.StringType
                }
            )
        ) {
            val message = remember {
                it.arguments?.getString("message")
            }
            Text(text = "Message: $message")
        }
    }

}