package com.roblesdotdev.jetrestaurants

class GetInitialRestaurantsUseCase {
    private val repository: RestaurantsRepository =
        RestaurantsRepository()
    private val getSortedRestaurantsUseCase = GetSortedRestaurantsUseCase()

    suspend operator fun invoke(): List<Restaurant> {
        repository.loadRestaurants()
        return getSortedRestaurantsUseCase()
    }
}