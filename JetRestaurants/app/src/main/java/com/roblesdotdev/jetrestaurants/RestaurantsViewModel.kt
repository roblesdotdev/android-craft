package com.roblesdotdev.jetrestaurants

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.ConnectException
import java.net.UnknownHostException

class RestaurantsViewModel : ViewModel() {
    private var restInterface: RestaurantsApiService
    val state = mutableStateOf(emptyList<Restaurant>())
    private var restaurantsDao =
        RestaurantsDb.getDaoInstance(RestaurantsApplication.getAppContext())

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
    }

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl("https://restaurants-app-b8c89-default-rtdb.firebaseio.com/")
            .build()
        restInterface = retrofit.create(RestaurantsApiService::class.java)
        getRestaurants()
    }

    fun toggleFavorite(id: Int) {
        val restaurants = state.value.toMutableList()
        val itemIndex = restaurants.indexOfFirst { it.id == id }
        val item = restaurants[itemIndex]
        restaurants[itemIndex] = item.copy(isFavorite = !item.isFavorite)
        state.value = restaurants
    }

    private fun getRestaurants() {
        viewModelScope.launch(errorHandler) {
            val restaurants = getAllRestaurants()
            state.value = restaurants
        }
    }

    private suspend fun getAllRestaurants(): List<Restaurant> {
        return withContext(Dispatchers.IO) {
            try {
                val restaurants = restInterface.getRestaurants()
                restaurantsDao.addAll(restaurants)
                return@withContext restaurants
            } catch (e: Exception) {
                when (e) {
                    is UnknownHostException,
                    is ConnectException,
                    is HttpException
                    -> {
                        return@withContext restaurantsDao.getAll()
                    }
                    else -> throw e
                }
            }
        }
    }

}