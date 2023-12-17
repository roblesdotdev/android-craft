package com.roblesdotdev.jetretrofit

data class TodoState(
    val todos: List<Todo> = emptyList(),
    val isLoading: Boolean = false,
)
