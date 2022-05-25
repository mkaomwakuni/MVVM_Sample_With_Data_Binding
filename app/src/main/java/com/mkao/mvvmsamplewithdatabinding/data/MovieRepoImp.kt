package com.mkao.mvvmsamplewithdatabinding.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mkao.mvvmsamplewithdatabinding.data.db.MovieDao
import com.mkao.mvvmsamplewithdatabinding.data.model.Movie
import com.mkao.mvvmsamplewithdatabinding.data.model.MovieResponse
import com.mkao.mvvmsamplewithdatabinding.data.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

class MovieRepoImp :MovieRepository{

    private val movieDao: MovieDao = db.movieDao()
    private val retrofitClient = RetrofitClient()
    private  val allMovie: LiveData<List<Movie>> = movieDao.getAll()


    override fun getSavedMovies() = allMovie



    override fun saveMovie(movie: Movie) {
    thread {
        movieDao.insert(movie)
     }
    }

    override fun deleteMovie(movie: Movie) {
       thread {
           db.movieDao().delete(movie.id)
       }
    }

    override fun searchMovies(query: String): LiveData<List<Movie>> {

        val  data = MutableLiveData<List<Movie>>()

        retrofitClient.searchMovies(query).enqueue(object : Callback<MovieResponse>){
         override fun onFailure(call: Call<MovieResponse>,t: Throwable){
             data.value=null
             Log.d(this.javaClass.simpleName,"Failure")
         }
            override fun onResponse(call: Call<MovieResponse>,response: Response<MovieResponse>){
                data.value= response.body()?.results
                Log.d(this.javaClass.simpleName, "Response: ${response.body()?.results}")

            }
        })
        return data
    }
}