package com.roblesdotdev.jetrestaurants

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