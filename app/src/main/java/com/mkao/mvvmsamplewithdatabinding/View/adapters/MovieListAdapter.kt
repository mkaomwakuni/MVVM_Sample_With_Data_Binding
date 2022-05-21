package com.mkao.mvvmsamplewithdatabinding.View.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkao.mvvmsamplewithdatabinding.R
import com.mkao.mvvmsamplewithdatabinding.data.model.Movie

class MovieListAdapter(private val moviesList: MutableList<Movie>):RecyclerView.Adapter<MovieListAdapter.MovieHolder>() {
    val selectedMovies = HashSet<Movie>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieListAdapter.MovieHolder {
        val  view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_main,parent,false)
        return MovieHolder(view)
    }



    fun setMovies (moviesList: MutableList<Movie>){
        this.movies.clear()
        this.movie
    }


    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int  = moviesList.size
    //binding the ui
    inner class MovieHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie) = with(view){
            movieTitleTextView.Text = movie.title
            movieReleaseDateTextView.text =movie.releaseDate
            checkBx.isChecked  = movie.watched

            if (movie.posterPath!=null)
        }
    }
}