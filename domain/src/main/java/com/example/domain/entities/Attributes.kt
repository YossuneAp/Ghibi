package com.example.domain.entities

import java.text.SimpleDateFormat
import java.util.*

data class Attributes(
    val abbreviatedTitles: List<String>?=null,
    val ageRating: String?=null,
    val ageRatingGuide: String?=null,
    val averageRating: String?=null,
    val canonicalTitle: String?=null,
    val chapterCount: Int?=null,
    val coverImage: CoverImage?=null,
    val coverImageTopOffset: Int?=null,
    val createdAt: String?=null,
    val description: String?=null,
    val endDate: String?=null,
    val favoritesCount: Int?=null,
    val mangaType: String?=null,
    val nextRelease: Any?=null,
    val popularityRank: Int?=null,
    val posterImage: PosterImage?=null,
    val ratingFrequencies: RatingFrequencies?=null,
    val ratingRank: Int?=null,
    val serialization: String?=null,
    val slug: String?=null,
    val startDate: String?=null,
    val status: String?=null,
    val subtype: String?=null,
    val synopsis: String?=null,
    val tba: Any?=null,
    val titles: Titles??=null,
    val updatedAt: String?=null,
    val userCount: Int?=null,
    val volumeCount: Int?=null
){
     fun formatDate ():String{
         var stringDate=""
        createdAt?.let {
            val us = Locale("US")
            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'", us)
            val date = format.parse(createdAt)
             stringDate = SimpleDateFormat("dd/MM/yyyy", us).format(date)

        }
         return stringDate
    }
    fun formatYear ():String{
        var stringDate=""
        createdAt?.let {
            val us = Locale("US")
            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'", us)
            val date = format.parse(createdAt)
            stringDate = SimpleDateFormat("yyyy", us).format(date)

        }
        return stringDate
    }
}