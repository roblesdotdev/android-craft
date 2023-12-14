package com.roblesdotdev.jetrestaurants

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class RestaurantsViewModel : ViewModel() {
    private val repository = RestaurantsRepository()

    val state = mutableStateOf(
        RestaurantsScreenState(
            restaurants = emptyList(),
            isLoading = true,
        )
    )

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
        state.value = state.value.copy(
            error = exception.message,
            isLoading = false,
        )
    }

    init {
        getRestaurants()
    }

    fun toggleFavorite(id: Int, oldValue: Boolean) {
        viewModelScope.launch(errorHandler) {
            val updatedRestaurants = repository.toggleFavoriteRestaurant(id, oldValue)
            state.value = state.value.copy(
                restaurants = updatedRestaurants
            )
        }
    }


    private fun getRestaurants() {
        viewModelScope.launch(errorHandler) {
            val restaurants = repository.getAllRestaurants()
            state.value = state.value.copy(
                restaurants = restaurants,
                isLoading = false
            )
        }
    }



}