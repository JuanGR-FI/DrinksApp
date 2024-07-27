package com.example.drinksapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.drinksapp.util.Constants
import com.google.gson.annotations.SerializedName

@Entity(tableName = Constants.DATABASE_FAVORITE_TABLE)
data class DrinkEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "userId") val userId: Int,
    @ColumnInfo(name = "idDrink") val idDrink: String,
    @ColumnInfo(name = "dateModified") val dateModified: String,
    @ColumnInfo(name = "strAlcoholic") val strAlcoholic: String,
    @ColumnInfo(name = "strCategory") val strCategory: String,
    @ColumnInfo(name = "strCreativeCommonsConfirmed") val strCreativeCommonsConfirmed: String,
    @ColumnInfo(name = "strDrink") val strDrink: String,
    @ColumnInfo(name = "strDrinkAlternate") val strDrinkAlternate: String?,
    @ColumnInfo(name = "strDrinkThumb") val strDrinkThumb: String,
    @ColumnInfo(name = "strGlass") val strGlass: String,
    @ColumnInfo(name = "strIBA") val strIBA: String,
    @ColumnInfo(name = "strImageAttribution") val strImageAttribution: String,
    @ColumnInfo(name = "strImageSource") val strImageSource: String,
    @ColumnInfo(name = "strIngredient1") val strIngredient1: String,
    @ColumnInfo(name = "strIngredient10") val strIngredient10: String?,
    @ColumnInfo(name = "strIngredient11") val strIngredient11: String?,
    @ColumnInfo(name = "strIngredient12") val strIngredient12: String?,
    @ColumnInfo(name = "strIngredient13") val strIngredient13: String?,
    @ColumnInfo(name = "strIngredient14") val strIngredient14: String?,
    @ColumnInfo(name = "strIngredient15") val strIngredient15: String?,
    @ColumnInfo(name = "strIngredient2") val strIngredient2: String,
    @ColumnInfo(name = "strIngredient3") val strIngredient3: String,
    @ColumnInfo(name = "strIngredient4") val strIngredient4: String,
    @ColumnInfo(name = "strIngredient5") val strIngredient5: String?,
    @ColumnInfo(name = "strIngredient6") val strIngredient6: String?,
    @ColumnInfo(name = "strIngredient7") val strIngredient7: String?,
    @ColumnInfo(name = "strIngredient8") val strIngredient8: String?,
    @ColumnInfo(name = "strIngredient9") val strIngredient9: String?,
    @ColumnInfo(name = "strInstructions") val strInstructions: String,
    @ColumnInfo(name = "strInstructionsDE") val strInstructionsDE: String,
    @ColumnInfo(name = "strInstructionsES") val strInstructionsES: String?,
    @ColumnInfo(name = "strInstructionsFR") val strInstructionsFR: String?,
    @ColumnInfo(name = "strInstructionsIT") val strInstructionsIT: String,
    @ColumnInfo(name = "strInstructionsZHHANS") val strInstructionsZHHANS: String?,
    @ColumnInfo(name = "strInstructionsZHHANT") val strInstructionsZHHANT: String?,
    @ColumnInfo(name = "strMeasure1") val strMeasure1: String,
    @ColumnInfo(name = "strMeasure10") val strMeasure10: String?,
    @ColumnInfo(name = "strMeasure11") val strMeasure11: String?,
    @ColumnInfo(name = "strMeasure12") val strMeasure12: String?,
    @ColumnInfo(name = "strMeasure13") val strMeasure13: String?,
    @ColumnInfo(name = "strMeasure14") val strMeasure14: String?,
    @ColumnInfo(name = "strMeasure15") val strMeasure15: String?,
    @ColumnInfo(name = "strMeasure2") val strMeasure2: String,
    @ColumnInfo(name = "strMeasure3") val strMeasure3: String,
    @ColumnInfo(name = "strMeasure4") val strMeasure4: String?,
    @ColumnInfo(name = "strMeasure5") val strMeasure5: String?,
    @ColumnInfo(name = "strMeasure6") val strMeasure6: String?,
    @ColumnInfo(name = "strMeasure7") val strMeasure7: String?,
    @ColumnInfo(name = "strMeasure8") val strMeasure8: String?,
    @ColumnInfo(name = "strMeasure9") val strMeasure9: String?,
    @ColumnInfo(name = "strTags") val strTags: String,
    @ColumnInfo(name = "strVideo") val strVideo: String?
)