package com.example.moviesbox.data.model

data class TopMoviesResponse(
    val page: Int,
    val results: List<TopMovie>,
    val total_pages: Int,
    val total_results: Int
)