package com.c22_067.whatdishtoday.network

import com.c22_067.whatdishtoday.data.MakananSearch
import com.c22_067.whatdishtoday.network.responses.RecipesResponse
import com.c22_067.whatdishtoday.network.responses.DetailRecipeResponse
import com.c22_067.whatdishtoday.network.responses.SearchRecipeResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @GET("/api/search/")
    fun findMakanan(
        @Query("q") query: String
    ): Call<RecipesResponse>

    @GET("/api/recipe/{key}") // dummy
    fun getMakananDetail( // resep-sambal-teri-petai
        @Path("key") param: String
    ): Call<DetailRecipeResponse>

    @GET("/api/recipes")
    fun getMakanan(): Call<RecipesResponse>
}