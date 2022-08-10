package com.example.moviesbox.domain

import com.example.moviesbox.data.model.Genre
import com.example.moviesbox.data.model.GenresReponce
import com.example.moviesbox.data.model.TopMoviesResponse
import io.reactivex.Single

interface MovieRepository {
    fun getGenres(): Single<GenresReponce>

    fun getTopMovie(): Single<TopMoviesResponse>
}