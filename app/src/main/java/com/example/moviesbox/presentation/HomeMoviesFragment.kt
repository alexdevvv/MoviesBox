package com.example.moviesbox.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.moviesbox.R
import com.example.moviesbox.databinding.FragmentHomeMoviesBinding


class HomeMoviesFragment : Fragment(R.layout.fragment_home_movies) {

    private lateinit var binding: FragmentHomeMoviesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeMoviesBinding.bind(view)

    }
}