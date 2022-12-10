package com.c22_067.whatdishtoday.network

import com.c22_067.whatdishtoday.network.responses.DetailRecipeResponse
import com.c22_067.whatdishtoday.network.responses.RecipesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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

    @GET("/api/recipes/{page}")
    fun getNextMakanan(): Call<RecipesResponse>
}