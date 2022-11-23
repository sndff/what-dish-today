package com.dicoding.picodiploma.homerecipe.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Config {
    private const val BASE_URL = "https://masak-apa.tomorisakura.vercel.app/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiInstance: Api = retrofit.create(Api::class.java)
}