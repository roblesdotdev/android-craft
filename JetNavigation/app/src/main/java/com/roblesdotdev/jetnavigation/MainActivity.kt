package com.roblesdotdev.jetnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.roblesdotdev.jetnavigation.ui.theme.JetNavigationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNavigationTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "list_screen"
                ) {
                    composable("list_screen") {
                        val message = "This is my message"
                        Column {
                            Text(text = "Hello, World")
                            Button(onClick = { navController.navigate("list_detail/$message" )}) {
                               Text(text = "Go to detail")
                            }
                        }
                    }
                    composable(
                        route = "list_detail/{message}",
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
        }
    }
}