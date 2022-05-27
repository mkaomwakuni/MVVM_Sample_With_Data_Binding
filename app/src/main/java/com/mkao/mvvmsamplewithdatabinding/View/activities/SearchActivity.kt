package com.mkao.mvvmsamplewithdatabinding.View.activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mkao.mvvmsamplewithdatabinding.data.MovieRepoImp
import com.mkao.mvvmsamplewithdatabinding.data.MovieRepository
import com.mkao.mvvmsamplewithdatabinding.data.model.Movie
import retrofit2.http.Query

class SearchActivity (private val repository: MovieRepository=MovieRepoImp()):ViewModel(){
    fun searchMovie(query: String): LiveData<List<Movie>> {
        return repository.searchMovies(query)
    }
    fun saveMovie(movie: Movie){
        repository.saveMovie(movie)
    }
}