package com.roblesdotdev.jetrestaurants.restaurants.presentation.list

import com.roblesdotdev.jetrestaurants.restaurants.domain.Restaurant

data class RestaurantsScreenState(
    val restaurants: List<Restaurant>,
    val isLoading: Boolean,
    val error: String? = null,
)