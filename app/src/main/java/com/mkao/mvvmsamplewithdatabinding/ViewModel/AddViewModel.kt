package com.mkao.mvvmsamplewithdatabinding.ViewModel

import androidx.lifecycle.ViewModel
import com.mkao.mvvmsamplewithdatabinding.data.MovieRepoImp
import com.mkao.mvvmsamplewithdatabinding.data.MovieRepository
import com.mkao.mvvmsamplewithdatabinding.data.model.Movie

class AddViewModel(private val repository: MovieRepository = MovieRepoImp()):ViewModel() {
    fun saveMovie(movie: Movie){
        repository.saveMovie(movie)
    }
}