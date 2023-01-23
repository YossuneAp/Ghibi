package com.example.ghibiapp.Dashboard

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.domain.Peliculas
import com.example.domain.entities.data
import com.example.ghibiapp.Dashboard.adapter.DashboardAdapter
import com.example.ghibiapp.databinding.FragmentDashboardBinding
import com.example.ghibiapp.dummpy.dummpyPeliculas


class DashboardFragment : Fragment() {


    private val viewmodel: DashboardViewModel by viewModels()
    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    var listPelis: List<Peliculas> = dummpyPeliculas.listpeliculas
     var listMovies: List<data> = ArrayList<data>()

    private lateinit var adapter: DashboardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
        ObserverViewModel()
    }

    private fun ObserverViewModel() {

        viewmodel.moviModel.observe(viewLifecycleOwner, Observer {
            it?.let {

                listMovies = ArrayList(it.data)
                val gridLayoutManager =GridLayoutManager (requireContext(),2)
                binding.reciclerviewPelis.setLayoutManager(gridLayoutManager);
                adapter=DashboardAdapter(listMovies,{onItemSelect(it)})
                binding.reciclerviewPelis.adapter= adapter
                binding.progress.visibility=View.GONE
                binding.reciclerviewPelis.visibility= View.VISIBLE
                search()
            }

        })
    }



    private fun setupUi() {

        binding.reciclerviewPelis.visibility= View.GONE
        viewmodel.getAllMovieViewModel()
        swiperRefres()

    }

    private fun swiperRefres() {

        with(binding){

            swipeRefresh.setOnRefreshListener {
                reciclerviewPelis.visibility= View.GONE
                binding.progress.visibility=View.VISIBLE
                swipeRefresh.isRefreshing= false
                viewmodel.getAllMovieViewModel()
            }
        }
    }

    fun onItemSelect(peli: data){

        val action:NavDirections = DashboardFragmentDirections.actionDashboardFragmentToDetailsFragment(peli.id!!)
        findNavController().navigate(action)
    }

    private fun search() {
        with(binding){
            search.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
               return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    listMovies?.let {
                        val list  = it.filter { data -> data.attributes!!.slug?.lowercase()!!.contains( newText!!.lowercase()) || data.attributes!!.formatDate().contains(newText.lowercase())}
                        if (list.size>0){
                            adapter.updateMovies(list)
                            empy.visibility=View.GONE
                            reciclerviewPelis.visibility=View.VISIBLE
                        }else{
                            empy.text="No Se encuentra Informacion"
                            empy.visibility=View.VISIBLE
                            reciclerviewPelis.visibility=View.GONE
                        }

                    }
                    return false
                }
           })
        }
    }



    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashboardFragment().apply {

            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


