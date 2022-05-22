package com.mkao.mvvmsamplewithdatabinding.data.network


import com.mkao.mvvmsamplewithdatabinding.data.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
     @GET("discover/movie")
     fun getMovies(@Query("api_key") api_key:String): Call<MovieResponse>
     @GET("search/movie")
     fun searchMovie(@Query("api_key") api_key: String, @Query("query") q:String):okhttp3.Call<MovieResponse>

}