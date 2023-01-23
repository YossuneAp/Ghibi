package com.example.ghibiapp.Details

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.ghibiapp.Dashboard.DashboardViewModel
import com.example.ghibiapp.Dashboard.adapter.DashboardAdapter
import com.example.ghibiapp.R
import com.example.ghibiapp.databinding.FragmentDashboardBinding
import com.example.ghibiapp.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private val viewmodel: DetailsViewModel by viewModels()
    private var _binding: FragmentDetailsBinding? = null

    private val binding get() = _binding!!
    private  val args:DetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
        ObserverViewModel()
    }

    private fun ObserverViewModel() {
        viewmodel.moviModelResponse.observe(viewLifecycleOwner, Observer {
            it?.let {dataResponse->

                dataResponse?.let { itData->
                     if (itData.data != null){
                         with(binding){
                             Glide.with(detailsOriginal.imageViewAnime.context).load(dataResponse.data?.attributes?.posterImage?.original).into(detailsOriginal.imageViewAnime)
                             detailsOriginal.titleAnime.text=dataResponse.data?.attributes?.canonicalTitle.toString()
                             detailsOriginal.subtitleAnime.text=dataResponse.data?.attributes?.slug?.toString()
                             detailsOriginal.Descripcion.text=dataResponse.data?.attributes?.description.toString()
                             detailsOriginal.setEdadPermitida.text=dataResponse.data?.attributes?.ageRatingGuide
                             detailsOriginal.setestatus.text=dataResponse.data?.attributes?.status
                             detailsOriginal.duracionAnime.text = dataResponse.data?.type
                             detailsOriginal.CalificacionAnime.text = dataResponse.data?.attributes?.popularityRank.toString()
                             detailsOriginal.fechaLanzamiento.text = dataResponse?.data?.attributes?.formatYear().toString()
                             original.visibility = View.VISIBLE
                             skeleton.stopShimmer()
                             skeleton.visibility=View.GONE
                         }
                     }else{
                         Toast.makeText(requireContext(), "No se encontro detalle ", Toast.LENGTH_SHORT).show()
                          findNavController().popBackStack()
                     }


                }






            }

        })
    }

    private fun setupUi() {
        with(binding) {
            skeleton.visibility=View.VISIBLE
            original.visibility = View.GONE
            skeleton.startShimmer()

        viewmodel.getAllMovieIdViewModel(args.id)
        swiperRefres()


    }
    }

    private fun swiperRefres() {

        with(binding){

           detailsOriginal.swipeRefresh.setOnRefreshListener {
               skeleton.visibility=View.VISIBLE
               original.visibility = View.GONE
               skeleton.startShimmer()
               detailsOriginal.swipeRefresh.isRefreshing= false
                viewmodel.getAllMovieIdViewModel(args.id)
            }
        }
    }
}