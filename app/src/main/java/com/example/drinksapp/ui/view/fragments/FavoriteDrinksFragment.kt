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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drinksapp.R
import com.example.drinksapp.data.model.DrinkModel
import com.example.drinksapp.databinding.FragmentFavoriteDrinksBinding
import com.example.drinksapp.ui.adapters.DrinksAdapter
import com.example.drinksapp.ui.viewmodel.DrinkViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteDrinksFragment : Fragment() {
    private var _binding: FragmentFavoriteDrinksBinding? = null
    private val binding get() = _binding!!

    private var drinks = mutableListOf<DrinkModel>()

    private val args: FavoriteDrinksFragmentArgs by navArgs()

    private val drinkViewModel: DrinkViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteDrinksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userId = args.userId

        val myAdapter = DrinksAdapter(true, drinks, mutableListOf(), { id ->
            findNavController()
                .navigate(
                    FavoriteDrinksFragmentDirections
                        .actionFavoriteDrinksFragmentToDrinkDetailFragment(drinkId = id)
                )

        }, { drink ->
            //Inhabilitar boton
        })

        binding.rvFavorites.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter

        }

        binding.btnExit.setOnClickListener {
            showExitDialog()
        }

        drinkViewModel.getFavorites(userId)

        drinkViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.progressBarFavs.isVisible = it
        })

        drinkViewModel.favDrinkList.observe(viewLifecycleOwner, Observer { favList ->
            Log.i("FAVS", favList.toString())
            myAdapter.drinks = favList.toMutableList()
            myAdapter.notifyDataSetChanged()
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