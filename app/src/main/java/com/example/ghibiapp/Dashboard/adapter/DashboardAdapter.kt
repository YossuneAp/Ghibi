package com.example.ghibiapp.Dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.data
import com.example.ghibiapp.R

//class DashboardAdapter(private val peliculas: List<Peliculas>, private val onClickListener:(Peliculas)-> Unit): RecyclerView.Adapter<DashboardViewHolder> () {
class DashboardAdapter(private var peliculas: List<data>, private val onClickListener:(data)-> Unit): RecyclerView.Adapter<DashboardViewHolder> () {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val layourInflate= LayoutInflater.from(parent.context)
        return DashboardViewHolder(layourInflate.inflate(R.layout.item_peliculas,parent,false))

    }

    override fun getItemCount(): Int =    peliculas.size


    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.render(peliculas[position],onClickListener)
    }


    fun updateMovies(listado:List<data>){
        peliculas = listado
        notifyDataSetChanged()
    }

}