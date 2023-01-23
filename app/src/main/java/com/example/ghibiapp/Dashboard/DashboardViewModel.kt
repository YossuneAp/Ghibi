package com.example.ghibiapp.Dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Movies
import com.example.ghibiapp.Dashboard.useCase.getMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class DashboardViewModel  : ViewModel() {

    val moviModel= MutableLiveData<Movies>()


    var getMoviesUsecas = getMovieUseCase()


    fun getAllMovieViewModel(){
        viewModelScope.launch {
            val result:Movies?=getMoviesUsecas()
           result?.let {
               moviModel.postValue(result!!)
           }
        }
    }



}