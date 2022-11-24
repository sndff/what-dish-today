package com.c22_067.whatdishtoday.network.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.c22_067.whatdishtoday.network.Config
import com.c22_067.whatdishtoday.network.responses.*
import com.dicoding.picodiploma.homerecipe.datasource.Makanan
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class HomeRepository {
    private val executorService : ExecutorService = Executors.newSingleThreadExecutor()
    // recipes
    private var getRecipes = MutableLiveData<List<ResultsRecipesItem?>>()
    val recipe: LiveData<List<ResultsRecipesItem?>> = getRecipes
    // detail recipes
    private var getDetailRecipes = MutableLiveData<ResultsDetail?>()
    val detail: LiveData<ResultsDetail?> = getDetailRecipes
    // search recipes
    private var findRecipes = MutableLiveData<ResultsSearchItem?>()
    val search: LiveData<ResultsSearchItem?> = findRecipes

    fun getRecipes() {
        executorService.execute { recipes() }
    }

    fun getDetailRecipes(param: String){
        executorService.execute { detail(param) }
    }

    fun findRecipes(param: String){
        executorService.execute { find(param) }
    }

    private fun detail(param: String){
        val client = Config.getApiService().getMakananDetail(param)
        client.enqueue(object : Callback<DetailRecipeResponse> {
            override fun onResponse(
                call: Call<DetailRecipeResponse>,
                response: Response<DetailRecipeResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        getDetailRecipes.value = response.body()!!.results
                    }

                } else {
//                    binding.progressBar.visibility = View.GONE
//                    Toast.makeText(activity, "Failed To Fetch Stories", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<DetailRecipeResponse>, t: Throwable) {
                Log.e("Error on Story Activity", "${t.message}")
            }
        })
    }

    private fun recipes(){
        val client = Config.getApiService().getMakanan()
        client.enqueue(object : Callback<RecipesResponse> {
            override fun onResponse(
                call: Call<RecipesResponse>,
                response: Response<RecipesResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        getRecipes.value = response.body()?.results!!
                    }
                } else {
//                    binding.progressBar.visibility = View.GONE
//                    Toast.makeText(activity, "Failed To Fetch Stories", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<RecipesResponse>, t: Throwable) {
                Log.e("Error on Story Activity", "${t.message}")
            }
        })
    }

    private fun find(param: String){
        val client = Config.getApiService().findMakanan(param)
        client.enqueue(object : Callback<SearchRecipeResponse> {
            override fun onResponse(
                call: Call<SearchRecipeResponse>,
                response: Response<SearchRecipeResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
//                        getRecipes.value = response.body().results
                    }
                } else {
//                    binding.progressBar.visibility = View.GONE
//                    Toast.makeText(activity, "Failed To Fetch Stories", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<SearchRecipeResponse>, t: Throwable) {
                Log.e("Error on Story Activity", "${t.message}")
            }
        })
    }
}