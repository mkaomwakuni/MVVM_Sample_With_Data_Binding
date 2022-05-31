package com.mkao.mvvmsamplewithdatabinding.View.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkao.mvvmsamplewithdatabinding.R
import com.mkao.mvvmsamplewithdatabinding.data.model.Movie

class MovieListAdapter (private val movies:MutableList<Movie>):RecyclerView.Adapter<MovieListAdapter.MovieHolder>() {
    val selectedMovies = HashSet<Movie>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieListAdapter.MovieHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_main,parent,false)
        return SearchListAdapter.MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListAdapter.MovieHolder, position: Int) {
        holder.bind(movies[position])
    }
    fun setMovies(movieList: List<Movie>){
        this.movies.clear()
        this.movies.addAll(movieList)
    }
}