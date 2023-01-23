package com.example.ghibiapp.Dashboard.useCase

import com.example.data.c.MovieRepository
import com.example.domain.entities.Movies

class getMovieUseCase {
    private val respository= MovieRepository()

    suspend operator fun invoke(): Movies?{
        return respository.getAllMoviesRepository()

    }

}