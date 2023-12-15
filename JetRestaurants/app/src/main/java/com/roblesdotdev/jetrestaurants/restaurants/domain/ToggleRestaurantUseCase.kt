package com.roblesdotdev.jetrestaurants.restaurants.domain

import com.roblesdotdev.jetrestaurants.restaurants.data.RestaurantsRepository
import javax.inject.Inject

class ToggleRestaurantUseCase @Inject constructor(
    private val repository: RestaurantsRepository,
    private val getSortedRestaurantsUseCase: GetSortedRestaurantsUseCase
) {
    suspend operator fun invoke(
        id: Int,
        oldValue: Boolean,
    ): List<Restaurant> {
        val newValue = oldValue.not()
        repository.toggleFavoriteRestaurant(id, newValue)
        return getSortedRestaurantsUseCase()
    }
}