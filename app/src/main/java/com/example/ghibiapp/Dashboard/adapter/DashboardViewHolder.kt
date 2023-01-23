package com.example.ghibiapp.Dashboard.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.data
import com.example.ghibiapp.databinding.ItemPeliculasBinding

class DashboardViewHolder (view: View): RecyclerView.ViewHolder(view){

    val binding = ItemPeliculasBinding.bind(view)

  //  fun render (peliculasModel: Peliculas, onClickListener:(Peliculas)-> Unit){
  fun render (peliculasModel: data, onClickListener:(data)-> Unit){

        binding.title.text= peliculasModel.attributes?.canonicalTitle
        binding.year.text= peliculasModel.attributes?.formatDate().toString()

        Glide.with(binding.imagePeli.context).load(peliculasModel.attributes?.posterImage?.original).into(binding.imagePeli)

        itemView.setOnClickListener{
            onClickListener(peliculasModel)
        }
    }
}