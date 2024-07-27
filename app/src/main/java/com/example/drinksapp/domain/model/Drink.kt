package com.example.drinksapp.domain.model

import com.example.drinksapp.data.database.entities.DrinkEntity
import com.example.drinksapp.data.model.DrinkModel
import com.google.gson.annotations.SerializedName

data class Drink(
    val dateModified: String,
    val idDrink: String,
    val strAlcoholic: String,
    val strCategory: String,
    val strCreativeCommonsConfirmed: String,
    val strDrink: String,
    val strDrinkAlternate: String?,
    val strDrinkThumb: String,
    val strGlass: String,
    val strIBA: String,
    val strImageAttribution: String,
    val strImageSource: String,
    val strIngredient1: String,
    val strIngredient10: String?,
    val strIngredient11: String?,
    val strIngredient12: String?,
    val strIngredient13: String?,
    val strIngredient14: String?,
    val strIngredient15: String?,
    val strIngredient2: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strInstructions: String,
    val strInstructionsDE: String,
    val strInstructionsES: String?,
    val strInstructionsFR: String?,
    val strInstructionsIT: String,
    val strInstructionsZHHANS: String?,
    val strInstructionsZHHANT: String?,
    val strMeasure1: String,
    val strMeasure10: String?,
    val strMeasure11: String?,
    val strMeasure12: String?,
    val strMeasure13: String?,
    val strMeasure14: String?,
    val strMeasure15: String?,
    val strMeasure2: String,
    val strMeasure3: String,
    val strMeasure4: String?,
    val strMeasure5: String?,
    val strMeasure6: String?,
    val strMeasure7: String?,
    val strMeasure8: String?,
    val strMeasure9: String?,
    val strTags: String,
    val strVideo: String?
)

/*fun DrinkModel.toDomain() = Drink(
    dateModified,
    idDrink,
    strAlcoholic,
    strCategory,
    strCreativeCommonsConfirmed,
    strDrink,
    strDrinkAlternate,
    strDrinkThumb,
    strGlass,
    strIBA,
    strImageAttribution,
    strImageSource,
    strIngredient1,
    strIngredient10,
    strIngredient11,
    strIngredient12,
    strIngredient13,
    strIngredient14,
    strIngredient15,
    strIngredient2,
    strIngredient3,
    strIngredient4,
    strIngredient5,
    strIngredient6,
    strIngredient7,
    strIngredient8,
    strIngredient9,
    strInstructions,
    strInstructionsDE,
    strInstructionsES,
    strInstructionsFR,
    strInstructionsIT,
    strInstructionsZHHANS,
    strInstructionsZHHANT,
    strMeasure1,
    strMeasure10,
    strMeasure11,
    strMeasure12,
    strMeasure13,
    strMeasure14,
    strMeasure15,
    strMeasure2,
    strMeasure3,
    strMeasure4,
    strMeasure5,
    strMeasure6,
    strMeasure7,
    strMeasure8,
    strMeasure9,
    strTags,
    strVideo
)*/

/*fun DrinkEntity.toDomain() = Drink(
    dateModified,
    idDrink,
    strAlcoholic,
    strCategory,
    strCreativeCommonsConfirmed,
    strDrink,
    strDrinkAlternate,
    strDrinkThumb,
    strGlass,
    strIBA,
    strImageAttribution,
    strImageSource,
    strIngredient1,
    strIngredient10,
    strIngredient11,
    strIngredient12,
    strIngredient13,
    strIngredient14,
    strIngredient15,
    strIngredient2,
    strIngredient3,
    strIngredient4,
    strIngredient5,
    strIngredient6,
    strIngredient7,
    strIngredient8,
    strIngredient9,
    strInstructions,
    strInstructionsDE,
    strInstructionsES,
    strInstructionsFR,
    strInstructionsIT,
    strInstructionsZHHANS,
    strInstructionsZHHANT,
    strMeasure1,
    strMeasure10,
    strMeasure11,
    strMeasure12,
    strMeasure13,
    strMeasure14,
    strMeasure15,
    strMeasure2,
    strMeasure3,
    strMeasure4,
    strMeasure5,
    strMeasure6,
    strMeasure7,
    strMeasure8,
    strMeasure9,
    strTags,
    strVideo
)*/

/*
data class Drink(
    val dateModified: String,
    val idDrink: String,
    val strAlcoholic: String,
    val strCategory: String,
    val strCreativeCommonsConfirmed: String,
    val strDrink: String,
    val strDrinkAlternate: String?,
    val strDrinkThumb: String,
    val strGlass: String,
    val strIBA: String,
    val strImageAttribution: String,
    val strImageSource: String,
    val strIngredient1: String,
    val strIngredient10: String?,
    val strIngredient11: String?,
    val strIngredient12: String?,
    val strIngredient13: String?,
    val strIngredient14: String?,
    val strIngredient15: String?,
    val strIngredient2: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strInstructions: String,
    val strInstructionsDE: String,
    val strInstructionsES: String?,
    val strInstructionsFR: String?,
    val strInstructionsIT: String,
    val strInstructionsZHHANS: String?,
    val strInstructionsZHHANT: String?,
    val strMeasure1: String,
    val strMeasure10: String?,
    val strMeasure11: String?,
    val strMeasure12: String?,
    val strMeasure13: String?,
    val strMeasure14: String?,
    val strMeasure15: String?,
    val strMeasure2: String,
    val strMeasure3: String,
    val strMeasure4: String?,
    val strMeasure5: String?,
    val strMeasure6: String?,
    val strMeasure7: String?,
    val strMeasure8: String?,
    val strMeasure9: String?,
    val strTags: String,
    val strVideo: String?
)
 */