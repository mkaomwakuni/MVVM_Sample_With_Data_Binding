package com.mkao.mvvmsamplewithdatabinding.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mkao.mvvmsamplewithdatabinding.data.MovieRepoImp
import com.mkao.mvvmsamplewithdatabinding.data.MovieRepository
import com.mkao.mvvmsamplewithdatabinding.data.model.Movie


class SearchViewModel(private val repository: MovieRepository = MovieRepoImp()):ViewModel() {
    fun SearchMovie(query: String): LiveData<List<Movie>> {
        return repository.searchMovies(query)
    }
    fun saveMovie(movie: Movie){
        repository.saveMovie(movie)
    }
}