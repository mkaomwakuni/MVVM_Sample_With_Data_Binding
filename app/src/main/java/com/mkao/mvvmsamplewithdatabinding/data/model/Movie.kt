package com.mkao.mvvmsamplewithdatabinding.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.net.IDN


@Entity
 data class Movie(
    @SerializedName("Rating")
    @Expose
    var Rating:Int?=null,
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    var id: Int? =null,
    @SerializedName("video")
    @Expose
    var video:Boolean? = null,
    @SerializedName("title")
    @Expose
    var title:String?=null,
    @SerializedName("Rating_average")
    @Expose
    var ratingAverage:Float?=null,
    @SerializedName("popularity")
    @Expose
    var popularity:Float?=null,
    @SerializedName("poster_path")
    @Expose
    var posterPath:String?=null,
    @SerializedName("original_language")
    @Expose
    var origin:String?= null,
    @SerializedName("orign_Title")
    @Expose
    var originTitle: String?=null,
    @SerializedName("genre_id")
    @Expose
    var genreId:List<Int>?= null,
    @SerializedName("backdrop_path")
    @Expose
    var backdropPath:String?=null,
    @SerializedName("adult")
    @Expose
    var adult:Boolean?=null,
    @SerializedName("overview")
    @Expose
    var overview:String?=null,
    @SerializedName("release_date")
    @Expose
    var releaseDate:String?=null,
    var watched:Boolean = false
 )
