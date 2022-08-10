package com.example.moviesbox.presentation.recyclers_view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.moviesbox.R
import com.example.moviesbox.data.model.TopMovie

class TopMoviesAdapter: RecyclerView.Adapter<TopMovieViewHolder>() {

    private var listTopMovies = listOf<TopMovie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.top_movie_item, parent, false)
        return TopMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopMovieViewHolder, position: Int) {
        val topMovie = listTopMovies[position]
        Glide
            .with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w200/ + $topMovie.poster_path")
            .apply(
                RequestOptions()
            )
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.posterFilm)

    }

    override fun getItemCount(): Int {
        return listTopMovies.size
    }

    fun initTopMoviesList(list: List<TopMovie>){
        listTopMovies = list
        notifyDataSetChanged()
    }
}