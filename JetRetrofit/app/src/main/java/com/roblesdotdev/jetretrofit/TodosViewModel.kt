package com.roblesdotdev.jetretrofit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TodosViewModel : ViewModel() {
    private var restInterface: TodosApiService
    private val _state = mutableStateOf(TodoState(isLoading = true))
    val state: State<TodoState> = _state

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl(
                "https://jsonplaceholder.typicode.com/"
            )
            .build()
        restInterface = retrofit.create(TodosApiService::class.java)
        getTodos()
    }

    private fun getTodos() {
        viewModelScope.launch {
            val newTodos = restInterface.getTodos()
            _state.value = _state.value.copy(
                todos = newTodos,
                isLoading = false
            )
        }
    }
}