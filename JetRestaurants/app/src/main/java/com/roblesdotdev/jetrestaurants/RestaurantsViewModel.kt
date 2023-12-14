package com.roblesdotdev.jetrestaurants

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class RestaurantsViewModel : ViewModel() {
    private val repository = RestaurantsRepository()
    private val getInitialRestaurantsUseCase = GetInitialRestaurantsUseCase()
    private val toggleRestaurantUseCase = ToggleRestaurantUseCase()

    private val _state = mutableStateOf(
        RestaurantsScreenState(
            restaurants = emptyList(),
            isLoading = true,
        )
    )

    val state: State<RestaurantsScreenState>
        get() = _state

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
        _state.value = _state.value.copy(
            error = exception.message,
            isLoading = false,
        )
    }

    init {
        getRestaurants()
    }

    fun toggleFavorite(id: Int, oldValue: Boolean) {
        viewModelScope.launch(errorHandler) {
            val updatedRestaurants = toggleRestaurantUseCase(id, oldValue)
            _state.value = _state.value.copy(
                restaurants = updatedRestaurants
            )
        }
    }


    private fun getRestaurants() {
        viewModelScope.launch(errorHandler) {
            val restaurants = getInitialRestaurantsUseCase()
            _state.value = _state.value.copy(
                restaurants = restaurants,
                isLoading = false
            )
        }
    }


}