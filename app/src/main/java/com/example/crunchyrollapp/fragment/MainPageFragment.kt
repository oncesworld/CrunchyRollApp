package com.example.crunchyrollapp.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.crunchyrollapp.R
import com.example.crunchyrollapp.adapter.MoviesAdapter
import com.example.crunchyrollapp.databinding.FragmentMainPageBinding
import com.example.crunchyrollapp.entity.Movies

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.toolbarMainpage.title = "     crunchyroll"
        binding.toolbarMainpage.setTitleTextColor(Color.parseColor("#FFA500"))

        binding.rvMovie.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

        binding.justUpdatedMovie.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

        val movieList = ArrayList<Movies>()
        val movie1 = Movies(1, "Demon Slayer", "demon_slayer")
        val movie2 = Movies(2, "Attack on Titan", "attack_on_titan")
        val movie3 = Movies(3, "One Piece", "one_piece")
        val movie4 = Movies(4, "Jujutsu Kaisen", "jujutsu_kaisen")

        movieList.add(movie1)
        movieList.add(movie2)
        movieList.add(movie3)
        movieList.add(movie4)

        val movieListJustUpdated = ArrayList<Movies>()

        val movie5 = Movies(5, "Bleach", "bleach")
        val movie6 = Movies(6, "One Punch", "one_punch")
        val movie7 = Movies(7, "Death Note", "death_note")
        val movie8 = Movies(8, "Full Metal Alchemist", "full_metal")

        movieListJustUpdated.add(movie5)
        movieListJustUpdated.add(movie6)
        movieListJustUpdated.add(movie7)
        movieListJustUpdated.add(movie8)

        val movieAdapter = MoviesAdapter(requireContext(),movieList)
        val movieAdapter2 = MoviesAdapter(requireContext(),movieListJustUpdated)

        binding.rvMovie.adapter = movieAdapter
        binding.justUpdatedMovie.adapter = movieAdapter2

        return binding.root
    }
}