package com.roblesdotdev.jetrestaurants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.roblesdotdev.jetrestaurants.ui.theme.JetRestaurantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetRestaurantsTheme {
                // RestaurantsScreen()
                RestaurantDetailScreen()
            }
        }
    }
}
