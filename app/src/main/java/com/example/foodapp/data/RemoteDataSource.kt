package com.example.foodapp.data

import com.example.foodapp.data.network.FoodRecipesApi
import com.example.foodapp.models.FoodJoke
import com.example.foodapp.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
        private val foodRecipesApi: FoodRecipesApi
){

    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe>{
        return foodRecipesApi.getRecipes(queries)
    }
    suspend fun searchRecipes(searchQuery: Map<String, String>): Response<FoodRecipe>{
        return foodRecipesApi.searchRecipes(searchQuery)
    }

    suspend fun getFoodJoke(apiKey: String): Response<FoodJoke>{
        return foodRecipesApi.getFoodJoke(apiKey)
    }

}