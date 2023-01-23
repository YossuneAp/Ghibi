package com.example.data.c.CORE

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {


    fun getRetrofit (): Retrofit {
       return  Retrofit.Builder()
           .baseUrl("https://kitsu.io/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
    }
}