package com.example.moviesbox.data.Retrofit

import com.example.moviesbox.data.model.GenresReponce
import com.example.moviesbox.data.model.TopMoviesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("/3/genre/movie/list?api_key=e771b03c1d469d616387bea7e46f678a&language=ru-RU")
    fun getGenres(): Single<GenresReponce>

    @GET("/3/movie/popular?api_key=e771b03c1d469d616387bea7e46f678a&language=ru-Ru&page=2")
    fun getTopMovies(): Single<TopMoviesResponse>
}