package com.example.data.c.network

import com.example.data.c.CORE.RetrofitHelper
import com.example.domain.entities.Movie
import com.example.domain.entities.data
import com.example.domain.entities.Movies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class MoviesService {
    private val retrofit= RetrofitHelper.getRetrofit()

    suspend fun  getMovies():Movies{
        return withContext(Dispatchers.IO){
            val response: Response<Movies> = retrofit.create(MovieApiClient::class.java).getAllMovies()
            response.body()?: Movies(listOf())
        }

    }
    suspend fun  getMovieId(id:String): Movie {
        return withContext(Dispatchers.IO){
            val response2: Response<Movie> = retrofit.create(MovieApiClient::class.java).getMoviesId(id)
            response2.body()?:Movie()
        }

    }
}