package Recipe.api

import model.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {
    @GET("search")
    fun getRecipes(
        @Query("q") query: String,
        @Query("app_id") appId: String,
        @Query("key_id") appKey: String
    ): Call<RecipeResponse>
}