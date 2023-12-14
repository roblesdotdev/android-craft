package com.roblesdotdev.jetrestaurants

data class RestaurantsScreenState(
    val restaurants: List<Restaurant>,
    val isLoading: Boolean,
)