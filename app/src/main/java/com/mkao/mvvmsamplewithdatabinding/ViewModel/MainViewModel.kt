package com.mkao.mvvmsamplewithdatabinding.ViewModel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.mkao.mvvmsamplewithdatabinding.data.MovieRepoImp
import com.mkao.mvvmsamplewithdatabinding.data.MovieRepository
import com.mkao.mvvmsamplewithdatabinding.data.model.Movie

class MainViewModel(private val repository: MovieRepository = MovieRepoImp()):ViewModel(){
private val allMovies = MediatorLiveData<List<Movie>>()

    init {
        getAllMovies()
    }
    fun getSavedMovies() = allMovies

    private fun getAllMovies() {
        allMovies.addSource(repository.getSavedMovies()){movies->
            allMovies.postValue(movies)
        }
    }
    fun deleteSavedMovies(movie: Movie){
        repository.deleteMovie(movie)
    }
}