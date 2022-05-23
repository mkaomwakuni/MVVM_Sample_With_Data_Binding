package com.mkao.mvvmsamplewithdatabinding.data

import androidx.lifecycle.LiveData
import com.mkao.mvvmsamplewithdatabinding.data.model.Movie
import retrofit2.http.Query

interface MovieRepository {
    fun getSavedMovies(): LiveData<List<Movie>>

    fun saveMovie(movie: Movie)

    fun deleteMovie(movie: Movie)

    fun searchMovies(query: String):LiveData<List<Movie>>
}