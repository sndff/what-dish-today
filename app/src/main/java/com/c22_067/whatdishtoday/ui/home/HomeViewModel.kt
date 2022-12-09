package com.c22_067.whatdishtoday.ui.home

import android.app.Application
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.res.Configuration
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.c22_067.whatdishtoday.data.MakananSearch
import com.c22_067.whatdishtoday.ui.home.adapter.RecipeListsAdapter
import com.c22_067.whatdishtoday.databinding.ActivityHomeBinding
import com.c22_067.whatdishtoday.network.Config
import com.c22_067.whatdishtoday.network.repository.MainRepository
import com.c22_067.whatdishtoday.network.responses.RecipesResponse
import com.c22_067.whatdishtoday.network.responses.ResultsRecipesItem
import com.c22_067.whatdishtoday.network.responses.ResultsSearchItem
import com.c22_067.whatdishtoday.network.responses.SearchRecipeResponse
import com.c22_067.whatdishtoday.ui.detail.activity.DetailMenuActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val repository = MainRepository()

    fun find(activity: AppCompatActivity, binding: ActivityHomeBinding,query:String ){
        var search: List<ResultsRecipesItem?>?
        repository.findRecipes(query)
        repository.search.observeForever {
            search = it
            showRecipes(activity, binding.rvHomeListRecipe, search)
            binding.progressBar.visibility = View.GONE
        }
    }

    fun getRecipe(activity: AppCompatActivity, binding: ActivityHomeBinding){
        var recipes: List<ResultsRecipesItem?>?
        repository.getRecipes()
        repository.recipe.observeForever {
            recipes = it
            showRecipes(activity, binding.rvHomeListRecipe, recipes)
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun showRecipes(activity: AppCompatActivity, rv: RecyclerView, recipes: List<ResultsRecipesItem?>?) {
        if(activity.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            rv.layoutManager = GridLayoutManager(activity, 4)
        } else {
            rv.layoutManager = GridLayoutManager(activity, 2)
        }
        val recipeListAdapter = RecipeListsAdapter(recipes)
        rv.adapter = recipeListAdapter
        recipeListAdapter.setOnItemClickCallback(object : RecipeListsAdapter.OnItemClick{
            override fun onItemClicked(data: ResultsRecipesItem?) {
                showSelectedRecipe(activity, data?.key)
            }

            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // do nothing
            }
        })
    }

    private fun showSelectedRecipe(activity: AppCompatActivity, list: String?) {
        val intent = Intent(activity, DetailMenuActivity::class.java)
        intent.putExtra(DetailMenuActivity.KEY, list)
        activity.startActivity(intent)
    }
}