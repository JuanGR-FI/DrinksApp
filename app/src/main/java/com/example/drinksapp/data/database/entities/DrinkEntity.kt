package com.example.drinksapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.drinksapp.util.Constants
import com.google.gson.annotations.SerializedName

@Entity(tableName = Constants.DATABASE_FAVORITE_TABLE)
data class DrinkEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "idDrink") val idDrink: String,
    @ColumnInfo(name = "dateModified") val dateModified: String,
    @ColumnInfo(name = "strAlcoholic") val strAlcoholic: String,
    @ColumnInfo(name = "strCategory") val strCategory: String,
    @ColumnInfo(name = "strCreativeCommonsConfirmed") val strCreativeCommonsConfirmed: String,
    @ColumnInfo(name = "strDrink") val strDrink: String,
    @ColumnInfo(name = "strDrinkAlternate") val strDrinkAlternate: Any,
    @ColumnInfo(name = "strDrinkThumb") val strDrinkThumb: String,
    @ColumnInfo(name = "strGlass") val strGlass: String,
    @ColumnInfo(name = "strIBA") val strIBA: String,
    @ColumnInfo(name = "strImageAttribution") val strImageAttribution: String,
    @ColumnInfo(name = "strImageSource") val strImageSource: String,
    @ColumnInfo(name = "strIngredient1") val strIngredient1: String,
    @ColumnInfo(name = "strIngredient10") val strIngredient10: Any,
    @ColumnInfo(name = "strIngredient11") val strIngredient11: Any,
    @ColumnInfo(name = "strIngredient12") val strIngredient12: Any,
    @ColumnInfo(name = "strIngredient13") val strIngredient13: Any,
    @ColumnInfo(name = "strIngredient14") val strIngredient14: Any,
    @ColumnInfo(name = "strIngredient15") val strIngredient15: Any,
    @ColumnInfo(name = "strIngredient2") val strIngredient2: String,
    @ColumnInfo(name = "strIngredient3") val strIngredient3: String,
    @ColumnInfo(name = "strIngredient4") val strIngredient4: String,
    @ColumnInfo(name = "strIngredient5") val strIngredient5: Any,
    @ColumnInfo(name = "strIngredient6") val strIngredient6: Any,
    @ColumnInfo(name = "strIngredient7") val strIngredient7: Any,
    @ColumnInfo(name = "strIngredient8") val strIngredient8: Any,
    @ColumnInfo(name = "strIngredient9") val strIngredient9: Any,
    @ColumnInfo(name = "strInstructions") val strInstructions: String,
    @ColumnInfo(name = "strInstructionsDE") val strInstructionsDE: String,
    @ColumnInfo(name = "strInstructionsES") val strInstructionsES: Any,
    @ColumnInfo(name = "strInstructionsFR") val strInstructionsFR: Any,
    @ColumnInfo(name = "strInstructionsIT") val strInstructionsIT: String,
    @ColumnInfo(name = "strInstructionsZHHANS") val strInstructionsZHHANS: Any,
    @ColumnInfo(name = "strInstructionsZHHANT") val strInstructionsZHHANT: Any,
    @ColumnInfo(name = "strMeasure1") val strMeasure1: String,
    @ColumnInfo(name = "strMeasure10") val strMeasure10: Any,
    @ColumnInfo(name = "strMeasure11") val strMeasure11: Any,
    @ColumnInfo(name = "strMeasure12") val strMeasure12: Any,
    @ColumnInfo(name = "strMeasure13") val strMeasure13: Any,
    @ColumnInfo(name = "strMeasure14") val strMeasure14: Any,
    @ColumnInfo(name = "strMeasure15") val strMeasure15: Any,
    @ColumnInfo(name = "strMeasure2") val strMeasure2: String,
    @ColumnInfo(name = "strMeasure3") val strMeasure3: String,
    @ColumnInfo(name = "strMeasure4") val strMeasure4: Any,
    @ColumnInfo(name = "strMeasure5") val strMeasure5: Any,
    @ColumnInfo(name = "strMeasure6") val strMeasure6: Any,
    @ColumnInfo(name = "strMeasure7") val strMeasure7: Any,
    @ColumnInfo(name = "strMeasure8") val strMeasure8: Any,
    @ColumnInfo(name = "strMeasure9") val strMeasure9: Any,
    @ColumnInfo(name = "strTags") val strTags: String,
    @ColumnInfo(name = "strVideo") val strVideo: Any
)