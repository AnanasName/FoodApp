package com.example.foodapp.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foodapp.models.Result
import com.example.foodapp.util.Constants.Companion.FAVORITE_RECIPES_TABLE

@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoritesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
)