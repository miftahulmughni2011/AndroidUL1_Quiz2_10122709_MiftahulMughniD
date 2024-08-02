package com.miftahul.androidul1_quiz2_10122709_miftahulmughnidarojat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import Recipe.api.RecipeApi
import model.RecipeResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val appId = "198a2bd6"
    private val appKey = "5e55229380ce3ec450218ce45777a4d9"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.edamam.com/api/recipes/v2?type=public&q=chicken&app_id=198a2bd6&app_key=5e55229380ce3ec450218ce45777a4d9")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val recipeApi = retrofit.create(RecipeApi::class.java)

        recipeApi.getRecipes("chicken", appId, appKey).enqueue(object : Callback<RecipeResponse> {
            override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
                if (response.isSuccessful) {
                    val recipeResponse = response.body()
                    recipeResponse?.let {
                        for (hit in it.hits) {
                            Log.d("MainActivity", "Recipe: ${hit.recipe.label}")
                            Log.d("MainActivity", "Image: ${hit.recipe.image}")
                            Log.d("MainActivity", "Source: ${hit.recipe.source}")
                            Log.d("MainActivity", "URL: ${hit.recipe.url}")
                            Log.d("MainActivity", "Ingredients: ${hit.recipe.ingredientLines.joinToString()}")
                            Log.d("MainActivity", "Calories: ${hit.recipe.calories}")
                        }

                    }
                }
            }

            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                Log.e("MainActivity", "Error: ${t.message}")
            }
        })
    }
}
