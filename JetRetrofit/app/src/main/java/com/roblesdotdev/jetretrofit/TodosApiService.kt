package com.roblesdotdev.jetretrofit

import retrofit2.http.GET

interface TodosApiService {
    @GET("todos")
    suspend fun getTodos(): List<Todo>
}