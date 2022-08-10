package com.example.moviesbox.domain

import com.example.moviesbox.data.model.GenresReponce
import io.reactivex.Single

class GetGenresUseCase(private val repository: MovieRepository) {
    fun getGenres(): Single<GenresReponce> =
        repository.getGenres()
}