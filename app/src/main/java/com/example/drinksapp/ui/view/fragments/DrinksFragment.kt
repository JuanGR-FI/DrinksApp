package com.example.drinksapp.ui.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.drinksapp.R
import com.example.drinksapp.data.model.Drink
import com.example.drinksapp.databinding.FragmentDrinksBinding
import com.example.drinksapp.ui.adapters.DrinksAdapter
import com.example.drinksapp.ui.viewmodel.DrinkViewModel

class DrinksFragment : Fragment() {
    private var _binding: FragmentDrinksBinding? = null
    private val binding get() = _binding!!

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

        val myAdapter = DrinksAdapter(drinks)

        binding.rvDrinks.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter
        }

        drinkViewModel.getDrinks('a')

        drinkViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.progressBarDrinks.isVisible = it
        })

        drinkViewModel.drinkList.observe(viewLifecycleOwner, Observer { drinkList ->
            Log.i("DRINKS", drinkList.toString())
            Log.i("DRINKS", "TAM: ${drinkList.size}")
            myAdapter.drinks = drinkList.toMutableList()
            myAdapter.notifyDataSetChanged()
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}