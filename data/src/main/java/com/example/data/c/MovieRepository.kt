package com.example.data.c

import com.example.data.c.network.MoviesService
import com.example.domain.entities.Movie
import com.example.domain.entities.data
import com.example.domain.entities.Movies

class MovieRepository {

    private val api= MoviesService()

    suspend fun  getAllMoviesRepository():Movies{
        val response:Movies= api.getMovies()
        return response
    }
    suspend fun  getAllMoviesIdRepository(id:String): Movie {
        val response:Movie= api.getMovieId(id)
        return response
    }

}