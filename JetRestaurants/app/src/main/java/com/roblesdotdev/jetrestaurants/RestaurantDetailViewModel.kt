package com.roblesdotdev.jetrestaurants

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantDetailViewModel(
    private val stateHandle: SavedStateHandle
) : ViewModel() {
    private var restInterface: RestaurantsApiService
    val state = mutableStateOf<Restaurant?>(null)

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://restaurants-app-b8c89-default-rtdb.firebaseio.com/")
            .build()
        restInterface = retrofit.create(
            RestaurantsApiService::class.java
        )
        val restaurantId = stateHandle.get<Int>("restaurant_id") ?: 0
        viewModelScope.launch {
            val restaurant = getRemoteRestaurant(restaurantId)
            state.value = restaurant
        }
    }

    private suspend fun getRemoteRestaurant(id: Int): Restaurant {
        return withContext(Dispatchers.IO) {
            val responseMap = restInterface.getRestaurant(id)
            return@withContext responseMap.values.first().let {
                Restaurant(
                    id = it.id,
                    title = it.title,
                    description = it.description,
                )
            }
        }
    }
}