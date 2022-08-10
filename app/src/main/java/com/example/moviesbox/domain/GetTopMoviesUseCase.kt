package com.example.moviesbox.domain

import com.example.moviesbox.data.Retrofit.ApiService
import com.example.moviesbox.data.model.TopMoviesResponse
import io.reactivex.Single

class GetTopMoviesUseCase(private val repository: MovieRepository) {
    fun getTopMovie(): Single<TopMoviesResponse> =
        repository.getTopMovie()

}