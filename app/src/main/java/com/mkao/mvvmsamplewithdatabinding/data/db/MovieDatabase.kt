package com.mkao.mvvmsamplewithdatabinding.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mkao.mvvmsamplewithdatabinding.data.model.Movie

@Database(entities = [Movie::class],version=1)
@TypeConverters(genreIDconverter::class)
abstract class MovieDatabase: RoomDatabase() {
abstract fun MovieDao():MovieDao

companion object{
    private val lock = Any()
    private const val DB_NAME = "MovieDatabase"
    private var INSTANCE:MovieDatabase?=null

    fun getInstance(application:Application):MovieDatabase{
        synchronized(MovieDatabase.lock){
            if (MovieDatabase.INSTANCE==null){
                MovieDatabase.INSTANCE =Room.databaseBuilder(application,MovieDatabase::class.java,MovieDatabase.DB_NAME)
                    .build()
            }
        }
        return INSTANCE!!
    }
  }
}