package com.example.moviesbox.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesbox.R
import com.example.moviesbox.data.model.TopMovie
import com.example.moviesbox.databinding.FragmentHomeMoviesBinding
import com.example.moviesbox.presentation.recyclers_view.TopMoviesAdapter


class HomeMoviesFragment : Fragment(R.layout.fragment_home_movies) {

    private lateinit var binding: FragmentHomeMoviesBinding
    private lateinit var homeMoviesViewModel: HomeMoviesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeMoviesBinding.bind(view)
        homeMoviesViewModel = ViewModelProvider(this).get(HomeMoviesViewModel::class.java)
        bindLiveData()

        homeMoviesViewModel.getGenreResponse()
        homeMoviesViewModel.getTopMovies()

    }

    private fun bindLiveData(){
        homeMoviesViewModel.getTopMovieLivedata().observe(requireActivity()) {
            initRecyclerView(it)
        }
    }

    private fun initRecyclerView(list: List<TopMovie>){
        val rv = binding.topMoviesRv
        val topMoviesAdapter = TopMoviesAdapter()
        rv.adapter = topMoviesAdapter
        rv.layoutManager = GridLayoutManager(requireContext(), 3)
//        rv.layoutManager = LinearLayoutManager(requireContext())
        topMoviesAdapter.initTopMoviesList(list)
    }
}