package com.example.drinksapp.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.drinksapp.R
import com.example.drinksapp.data.model.DrinkModel
import com.example.drinksapp.databinding.FragmentDrinkDetailBinding
import com.example.drinksapp.domain.model.Drink
import com.example.drinksapp.ui.viewmodel.DrinkViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DrinkDetailFragment : Fragment() {
    private var _binding: FragmentDrinkDetailBinding? = null
    private val binding get() = _binding!!

    private val args: DrinkDetailFragmentArgs by navArgs()

    private val drinkViewModel: DrinkViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDrinkDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = args.drinkId

        drinkViewModel.getDrinkDetail(id)

        drinkViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.progressBarDrinkDetail.isVisible = it
        })

        drinkViewModel.drink.observe(viewLifecycleOwner, Observer { drink ->
            //Log.i("DRINKDETAIL", "${drink.strDrink}")
            binding.svContent.isVisible = true
            prepareUI(drink)
        })


    }

    private fun prepareUI(drink: Drink) {
        binding.apply {

            btnExit.setOnClickListener {
                findNavController().navigateUp()
            }

            tvDrinkDetailName.text = drink.strDrink
            tvInstructions.text = drink.strInstructions

            tvIngredients.text = prepareIngredientList(drink)

            Picasso.get()
                .load(drink.strDrinkThumb)
                .placeholder(R.drawable.img_drinks_placeholder)
                .error(R.drawable.img_image_not_found)
                .into(ivDrinkDetailThumbnail)


        }
    }

    private fun prepareIngredientList(drink: Drink): String {
        var ingredientListStr = ""

        if (drink.strIngredient1 != null) {
            ingredientListStr += "- ${drink.strIngredient1}\n"
        }
        if (drink.strIngredient2 != null) {
            ingredientListStr += "- ${drink.strIngredient2}\n"
        }
        if (drink.strIngredient3 != null) {
            ingredientListStr += "- ${drink.strIngredient3}\n"
        }
        if (drink.strIngredient4 != null) {
            ingredientListStr += "- ${drink.strIngredient4}\n"
        }
        if (drink.strIngredient5 != null) {
            ingredientListStr += "- ${drink.strIngredient5}\n"
        }
        if (drink.strIngredient6 != null) {
            ingredientListStr += "- ${drink.strIngredient6}\n"
        }
        if (drink.strIngredient7 != null) {
            ingredientListStr += "- ${drink.strIngredient7}\n"
        }
        if (drink.strIngredient8 != null) {
            ingredientListStr += "- ${drink.strIngredient8}\n"
        }
        if (drink.strIngredient9 != null) {
            ingredientListStr += "- ${drink.strIngredient9}\n"
        }
        if (drink.strIngredient10 != null) {
            ingredientListStr += "- ${drink.strIngredient10}\n"
        }
        if (drink.strIngredient11 != null) {
            ingredientListStr += "- ${drink.strIngredient11}\n"
        }
        if (drink.strIngredient12 != null) {
            ingredientListStr += "- ${drink.strIngredient12}\n"
        }
        if (drink.strIngredient13 != null) {
            ingredientListStr += "- ${drink.strIngredient13}\n"
        }
        if (drink.strIngredient14 != null) {
            ingredientListStr += "- ${drink.strIngredient14}\n"
        }
        if (drink.strIngredient15 != null) {
            ingredientListStr += "- ${drink.strIngredient15}\n"
        }

        return ingredientListStr.trim()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}