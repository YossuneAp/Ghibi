package com.example.ghibiapp.Details.UseCase

import com.example.data.c.MovieRepository
import com.example.domain.entities.Movie
import com.example.domain.entities.data

class getMovieIdUseCase {

    private val respository= MovieRepository()

    suspend operator fun invoke(id:String): Movie?{
        return respository.getAllMoviesIdRepository(id)

    }

}