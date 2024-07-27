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
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drinksapp.data.model.DrinkModel
import com.example.drinksapp.databinding.FragmentDrinksBinding
import com.example.drinksapp.domain.model.Drink
import com.example.drinksapp.ui.adapters.DrinksAdapter
import com.example.drinksapp.ui.viewmodel.DrinkViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DrinksFragment : Fragment() {
    private var _binding: FragmentDrinksBinding? = null
    private val binding get() = _binding!!

    private val args: DrinksFragmentArgs by navArgs()

    private var isFirstLoad: Boolean = false
    private var mRootView: ViewGroup? = null

    private var currentPage = 0
    private var isLoading = false

    private var drinks = mutableListOf<DrinkModel>()

    private val drinkViewModel: DrinkViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDrinksBinding.inflate(inflater, container, false)

        if (mRootView == null) {
            mRootView = _binding?.root
            isFirstLoad = true
        } else {
            isFirstLoad = false
        }

        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userId = args.userId

        if (isFirstLoad) {
            if (drinks.isEmpty()) {
                drinkViewModel.getFavorites(userId)
            }
        }

        val myAdapter = DrinksAdapter(false, drinks, mutableListOf(), { id ->
            findNavController()
                .navigate(
                    DrinksFragmentDirections
                        .actionDrinksFragmentToDrinkDetailFragment(drinkId = id)
                )

        }, { drink ->
            drinkViewModel.insertFavorite(drink, userId)
            Toast.makeText(requireContext(), "Cóctel agregado a favoritos", Toast.LENGTH_SHORT)
                .show()
        })



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

        binding.btnFav.setOnClickListener {
            findNavController().navigate(
                DrinksFragmentDirections.actionDrinksFragmentToFavoriteDrinksFragment(
                    userId = userId
                )
            )
        }

        binding.btnExit.setOnClickListener {
            showExitDialog()
        }

        drinkViewModel.favDrinkList.observe(viewLifecycleOwner, Observer { favsList ->
            myAdapter.favsList = favsList.toMutableList()
            drinkViewModel.getDrinks(currentPage)
        })

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

    private fun showExitDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Aviso!")
            .setMessage("¿Deseas salir de la aplicación?")
            .setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
                activity?.finish()
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}