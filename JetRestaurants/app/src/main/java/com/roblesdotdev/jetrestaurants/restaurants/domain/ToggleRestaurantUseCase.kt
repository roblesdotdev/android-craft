package com.roblesdotdev.jetrestaurants.restaurants.domain

import com.roblesdotdev.jetrestaurants.restaurants.data.RestaurantsRepository
import com.roblesdotdev.jetrestaurants.restaurants.domain.GetSortedRestaurantsUseCase
import com.roblesdotdev.jetrestaurants.restaurants.domain.Restaurant

class ToggleRestaurantUseCase {
    private val repository: RestaurantsRepository =
        RestaurantsRepository()
    private val getSortedRestaurantsUseCase = GetSortedRestaurantsUseCase()

    suspend operator fun invoke(
        id: Int,
        oldValue: Boolean,
    ): List<Restaurant> {
        val newValue = oldValue.not()
        repository.toggleFavoriteRestaurant(id, newValue)
        return getSortedRestaurantsUseCase()
    }
}