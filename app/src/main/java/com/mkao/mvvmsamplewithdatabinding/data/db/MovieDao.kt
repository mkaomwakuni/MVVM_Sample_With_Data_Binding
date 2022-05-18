package com.mkao.mvvmsamplewithdatabinding.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mkao.mvvmsamplewithdatabinding.data.model.Movie

@Dao
interface MovieDao {
    //upon duplicates strategy to resolve
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie:Movie)

    @Query("select * from movie")
    fun getAll():LiveData<List<Movie>>

    @Query("delete from movie where watched = :watched")
    fun delete(watched:Boolean)

    @Update
    fun updateMovie(movie: Movie)

    //upon delete of an entry
    @Query("DELETE FROM movie WHERE id = :id")
    fun delete(id:Int?)

}