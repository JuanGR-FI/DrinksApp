package com.example.drinksapp.ui.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drinksapp.R
import com.example.drinksapp.data.model.Drink
import com.example.drinksapp.databinding.FragmentDrinksBinding
import com.example.drinksapp.ui.adapters.DrinksAdapter
import com.example.drinksapp.ui.viewmodel.DrinkViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DrinksFragment : Fragment() {
    private var _binding: FragmentDrinksBinding? = null
    private val binding get() = _binding!!

    private var currentPage = 0
    private var isLoading = false

    private var drinks = mutableListOf<Drink>()

    private val drinkViewModel: DrinkViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDrinksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = DrinksAdapter(drinks) { id ->
            findNavController()
                .navigate(
                    DrinksFragmentDirections
                        .actionDrinksFragmentToDrinkDetailFragment(drinkId = id)
                )

        }

        binding.rvDrinks.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    if (!recyclerView.canScrollVertically(1)) {
                        if (!isLoading) {
                            isLoading = true
                            drinkViewModel.getDrinks(currentPage)
                        }

                    }

                }
            })
        }

        if (savedInstanceState == null) {
            if(drinks.isEmpty()){
                drinkViewModel.getDrinks(currentPage)
            }

        }

        drinkViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.progressBarDrinks.isVisible = it
            isLoading = it
        })

        drinkViewModel.drinkList.observe(viewLifecycleOwner, Observer { drinkList ->
            //Log.i("DRINKS", drinkList.toString())
            //Log.i("DRINKS", "TAM: ${drinkList.size}")
            //myAdapter.drinks = drinkList.toMutableList()
            myAdapter.drinks.addAll(drinkList)
            myAdapter.notifyDataSetChanged()

            currentPage++
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}