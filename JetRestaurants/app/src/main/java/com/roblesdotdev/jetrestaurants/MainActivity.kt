package com.roblesdotdev.jetrestaurants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roblesdotdev.jetrestaurants.ui.theme.JetRestaurantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetRestaurantsTheme {
                JetRestaurantApp()
            }
        }
    }
}

@Composable
fun JetRestaurantApp() {
    val navController = rememberNavController()
    NavHost(navController,  startDestination = "restaurants") {
        composable(route = "restaurants") {
            RestaurantsScreen()
        }
    }
    
}
