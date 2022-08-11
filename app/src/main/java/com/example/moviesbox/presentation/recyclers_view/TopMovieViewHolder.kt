package com.example.moviesbox.presentation.recyclers_view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesbox.R

class TopMovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val posterFilm = itemView.findViewById<ImageView>(R.id.poster_movie_iv)
}