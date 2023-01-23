package com.example.ghibiapp.Details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Movie
import com.example.domain.entities.data
import com.example.ghibiapp.Details.UseCase.getMovieIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class DetailsViewModel: ViewModel()  {

    val moviModelResponse= MutableLiveData<Movie>()


      var getMovieIdUserCas = getMovieIdUseCase()


   fun getAllMovieIdViewModel(id:String){
        viewModelScope.launch {
            val result: Movie?=getMovieIdUserCas(id)
            result?.let {
                moviModelResponse.postValue(result!!)
            }
        }
    }

}