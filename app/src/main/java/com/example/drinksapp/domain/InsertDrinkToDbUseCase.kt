package com.example.drinksapp.domain

import com.example.drinksapp.data.DrinkRepository
import com.example.drinksapp.data.database.entities.DrinkEntity
import com.example.drinksapp.data.model.DrinkModel
import javax.inject.Inject

class InsertDrinkToDbUseCase @Inject constructor(private val repository: DrinkRepository) {

    suspend fun insertFavorite(drinkModel: DrinkModel, userId: Int) {
        val drinkEntity = DrinkEntity(
            userId = userId,
            idDrink = drinkModel.idDrink,
            dateModified = drinkModel.dateModified,
            strAlcoholic = drinkModel.strAlcoholic,
            strCategory = drinkModel.strCategory,
            strCreativeCommonsConfirmed = drinkModel.strCreativeCommonsConfirmed,
            strDrink = drinkModel.strDrink,
            strDrinkAlternate = drinkModel.strDrinkAlternate,
            strDrinkThumb = drinkModel.strDrinkThumb,
            strGlass = drinkModel.strGlass,
            strIBA = drinkModel.strIBA,
            strImageAttribution = drinkModel.strImageAttribution,
            strImageSource = drinkModel.strImageSource,
            strIngredient1 = drinkModel.strIngredient1,
            strIngredient2 = drinkModel.strIngredient2,
            strIngredient3 = drinkModel.strIngredient3,
            strIngredient4 = drinkModel.strIngredient4,
            strIngredient5 = drinkModel.strIngredient5,
            strIngredient6 = drinkModel.strIngredient6,
            strIngredient7 = drinkModel.strIngredient7,
            strIngredient8 = drinkModel.strIngredient8,
            strIngredient9 = drinkModel.strIngredient9,
            strIngredient10 = drinkModel.strIngredient10,
            strIngredient11 = drinkModel.strIngredient11,
            strIngredient12 = drinkModel.strIngredient12,
            strIngredient13 = drinkModel.strIngredient13,
            strIngredient14 = drinkModel.strIngredient14,
            strIngredient15 = drinkModel.strIngredient15,
            strInstructions = drinkModel.strInstructions,
            strInstructionsDE = drinkModel.strInstructionsDE,
            strInstructionsES = drinkModel.strInstructionsES,
            strInstructionsFR = drinkModel.strInstructionsFR,
            strInstructionsIT = drinkModel.strInstructionsIT,
            strInstructionsZHHANS = drinkModel.strInstructionsZHHANS,
            strInstructionsZHHANT = drinkModel.strInstructionsZHHANT,
            strMeasure1 = drinkModel.strMeasure1,
            strMeasure2 = drinkModel.strMeasure2,
            strMeasure3 = drinkModel.strMeasure3,
            strMeasure4 = drinkModel.strMeasure4,
            strMeasure5 = drinkModel.strMeasure5,
            strMeasure6 = drinkModel.strMeasure6,
            strMeasure7 = drinkModel.strMeasure7,
            strMeasure8 = drinkModel.strMeasure8,
            strMeasure9 = drinkModel.strMeasure9,
            strMeasure10 = drinkModel.strMeasure10,
            strMeasure11 = drinkModel.strMeasure11,
            strMeasure12 = drinkModel.strMeasure12,
            strMeasure13 = drinkModel.strMeasure13,
            strMeasure14 = drinkModel.strMeasure14,
            strMeasure15 = drinkModel.strMeasure15,
            strTags = drinkModel.strTags,
            strVideo = drinkModel.strVideo
        )

        repository.insertFavorite(drinkEntity)

    }

}