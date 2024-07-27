package com.example.drinksapp.ui.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.drinksapp.R
import com.example.drinksapp.databinding.FragmentFavoriteDrinksBinding
import com.example.drinksapp.ui.viewmodel.DrinkViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteDrinksFragment : Fragment() {
    private var _binding: FragmentFavoriteDrinksBinding? = null
    private val binding get() = _binding!!

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

        drinkViewModel.getFavorites(userId)

        drinkViewModel.favDrinkList.observe(viewLifecycleOwner, Observer { favList ->
            Log.i("FAVS", favList.toString())
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}