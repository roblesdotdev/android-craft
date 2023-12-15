package com.roblesdotdev.jetrestaurants.restaurants.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.roblesdotdev.jetrestaurants.restaurants.presentation.details.RestaurantDetailScreen
import com.roblesdotdev.jetrestaurants.restaurants.presentation.list.RestaurantsScreen
import com.roblesdotdev.jetrestaurants.restaurants.presentation.list.RestaurantsViewModel
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
            val viewModel: RestaurantsViewModel = viewModel()
            RestaurantsScreen(
                state = viewModel.state.value,
                onItemClick = { id ->
                    navController.navigate("restaurants/$id")
                },
                onFavoriteClick = { id, oldValue ->
                    viewModel.toggleFavorite(id, oldValue)
                }
            )
        }
        composable(
            route = "restaurants/{restaurant_id}",
            arguments = listOf(navArgument("restaurant_id") {
                type = NavType.IntType
            })
        ) {
            RestaurantDetailScreen()
        }
    }
    
}
