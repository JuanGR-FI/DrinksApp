package com.example.drinksapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.drinksapp.R
import com.example.drinksapp.data.model.DrinkModel
import com.example.drinksapp.databinding.DrinkElementBinding
import com.example.drinksapp.domain.model.Drink
import com.squareup.picasso.Picasso

class DrinksAdapter(
    var drinks: MutableList<DrinkModel>,
    private val onDrinkClicked: (Int) -> Unit,
    private val onFavClicked: (DrinkModel) -> Unit
) :
    RecyclerView.Adapter<DrinksAdapter.ViewHolder>() {

    class ViewHolder(private val binding: DrinkElementBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val ivThumbnail = binding.ivDrinkThumbnail
        val btnFav = binding.btnFav

        fun bind(drink: DrinkModel) {
            binding.tvDrinkName.text = drink.strDrink
            binding.tvDrinkCategory.text = drink.strCategory
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DrinkElementBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = drinks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val drink = drinks[position]

        holder.bind(drink)

        holder.itemView.setOnClickListener {
            onDrinkClicked(drink.idDrink.toInt())
        }

        holder.btnFav.setOnClickListener {
            onFavClicked(drink)
        }

        Picasso.get()
            .load(drink.strDrinkThumb)
            .placeholder(R.drawable.img_drinks_placeholder)
            .error(R.drawable.img_image_not_found)
            .into(holder.ivThumbnail)


    }

}