package com.example.crunchyrollapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crunchyrollapp.databinding.CardDesignBinding
import com.example.crunchyrollapp.entity.Movies
import com.google.android.material.snackbar.Snackbar

class MoviesAdapter(var mContext:Context,var moviesList:List<Movies>)
    : RecyclerView.Adapter<MoviesAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim:CardDesignBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val movie = moviesList.get(position)
        val t = holder.tasarim

        t.imageViewDS.setImageResource(
            mContext.resources.getIdentifier(movie.pic,"drawable",mContext.packageName))

        t.textViewDS.text = movie.movieName

        t.textBurger.setOnClickListener {
            Snackbar.make(it,"${movie.movieName}",Snackbar.LENGTH_SHORT).show()
        }

        t.cardViewAnime.setOnClickListener {
            //val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            //Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}