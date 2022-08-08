package com.example.moviesbox

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviesbox.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.base_color)))
        initBottomNavigationMenu()

    }

   private fun initBottomNavigationMenu(){
        val navController = findNavController(R.id.fragmentContainer)
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}