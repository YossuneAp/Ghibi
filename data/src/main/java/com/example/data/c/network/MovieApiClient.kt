package com.example.data.c.network

import com.example.domain.entities.Movie
import retrofit2.Response
import retrofit2.http.GET

import com.example.domain.entities.data
import com.example.domain.entities.Movies
import retrofit2.http.Path

interface MovieApiClient {

    @GET("api/edge/trending/manga")
    suspend fun  getAllMovies():Response<Movies>

  @GET("api/edge/anime/{id}")
   suspend fun  getMoviesId(@Path("id") id:String): Response<Movie>






}