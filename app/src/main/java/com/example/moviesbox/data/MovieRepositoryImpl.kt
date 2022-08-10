package com.example.moviesbox.data

import com.example.moviesbox.data.Retrofit.ApiService
import com.example.moviesbox.data.model.Genre
import com.example.moviesbox.data.model.GenresReponce
import com.example.moviesbox.data.model.TopMoviesResponse
import com.example.moviesbox.domain.MovieRepository
import io.reactivex.Single

class MovieRepositoryImpl(val api: ApiService): MovieRepository {
    override fun getGenres(): Single<GenresReponce> =
        api.getGenres()

    override fun getTopMovie(): Single<TopMoviesResponse> =
        api.getTopMovies()

}