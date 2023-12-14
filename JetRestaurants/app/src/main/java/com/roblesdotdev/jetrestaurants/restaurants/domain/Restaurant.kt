package com.roblesdotdev.jetrestaurants.restaurants.domain

data class Restaurant(
    val id: Int,
    val title: String,
    val description: String,
    var isFavorite: Boolean = false,
)