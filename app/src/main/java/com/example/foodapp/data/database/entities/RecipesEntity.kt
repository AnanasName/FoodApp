package com.example.foodapp.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foodapp.models.FoodRecipe
import com.example.foodapp.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}