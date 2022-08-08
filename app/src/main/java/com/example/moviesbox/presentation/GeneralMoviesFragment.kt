package com.example.moviesbox.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.moviesbox.R
import com.example.moviesbox.databinding.FragmentGeneralMoviesBinding

class GeneralMoviesFragment : Fragment(R.layout.fragment_general_movies) {

    private lateinit var binding: FragmentGeneralMoviesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGeneralMoviesBinding.bind(view)


    }
}