package com.dicoding.picodiploma.homerecipe.network

import com.dicoding.picodiploma.homerecipe.datasource.DetailMakanan
import com.dicoding.picodiploma.homerecipe.datasource.Makanan
import com.dicoding.picodiploma.homerecipe.datasource.MakananSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("/api/search/?q={parameter}")
    @Headers()
    fun getSearchMakanan(
        @Query("q") query: String
    ): Call<MakananSearch>

    @GET("/api/recipe/:{key}")
    @Headers()
    fun getMakananDetail(
        @Path("username") username: String
    ): Call<DetailMakanan>

    @GET("/api/category/recipes/:{key}")
    @Headers()
    fun getMakanan(
        @Path("username") username: String
    ): Call<ArrayList<Makanan>>
}