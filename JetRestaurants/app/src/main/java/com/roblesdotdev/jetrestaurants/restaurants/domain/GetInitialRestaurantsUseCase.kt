package com.roblesdotdev.jetrestaurants.restaurants.domain

import com.roblesdotdev.jetrestaurants.restaurants.data.RestaurantsRepository
import javax.inject.Inject

class GetInitialRestaurantsUseCase @Inject constructor(
    private val repository: RestaurantsRepository,
    private val getSortedRestaurantsUseCase: GetSortedRestaurantsUseCase,
) {
    suspend operator fun invoke(): List<Restaurant> {
        repository.loadRestaurants()
        return getSortedRestaurantsUseCase()
    }
}