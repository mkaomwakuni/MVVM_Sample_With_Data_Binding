package com.mkao.mvvmsamplewithdatabinding.data.db

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class genreIDconverter {
    val gson =Gson()

    @TypeConverter
    fun stringToGenreList(data:String?):List<Int>{
        if (data==null){
            return Collection.emptyList()
        }
        val listype = object : TypeToken<List<Int>>() {}.type
        return gson.fromJson(data,listype)
    }
    @TypeConverter
    fun genreListToString(genreIds:List<Int>?):String{
        if (genreIds==null){
            return gson.toJson(Collection.emptyList<Int>())
        }
        return gson.toJson(genreIds)
    }
}