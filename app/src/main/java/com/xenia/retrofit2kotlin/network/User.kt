package com.xenia.retrofit2kotlin.network

// arguments similar to the response object provided by the API
data class User (
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)