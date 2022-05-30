package com.mkao.mvvmsamplewithdatabinding.data.network

import com.mkao.mvvmsamplewithdatabinding.data.model.MovieResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Query

class RetrofitClient {
    private val moviesApi:MoviesApi


    companion object{
        private const val API_KEY = "https://api.themoviedb.org/3/movie/550?api_key=8dcf0a09c3669089d7620ae86a648c4d"
        private const val TMDB_BASE_URL ="http://api.themoviedb.org/3/"
        private const val TMDB_IMAGEURL = "https://image.tmdb.org/t/p/w500/"
    }

    init {
        val builder = OkHttpClient.Builder()
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(TMDB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        moviesApi = retrofit.create(MoviesApi::class.java)
    }
    fun searchMovies(query:String): Call<MovieResponse> {
        return moviesApi.searchMovie(API_KEY,query)
    }
}