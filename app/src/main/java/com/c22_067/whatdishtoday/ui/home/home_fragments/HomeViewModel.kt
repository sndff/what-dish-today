package com.c22_067.whatdishtoday.ui.home.home_fragments

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.c22_067.whatdishtoday.databinding.ActivityHomeBinding
import com.c22_067.whatdishtoday.network.repository.HomeRepository
import com.c22_067.whatdishtoday.network.responses.ResultsDetail
import com.c22_067.whatdishtoday.network.responses.ResultsRecipesItem

class HomeViewModel : ViewModel(){
    private val repository = HomeRepository()

    fun getAllRecipes(activity: AppCompatActivity, binding: ActivityHomeBinding) {
        var recipesItem : List<ResultsRecipesItem?>? = null
        repository.getRecipes()
        repository.recipe.observeForever {
            recipesItem = it
            showRecipes(activity, binding, recipesItem)
        }
    }

    private fun showRecipes(activity: AppCompatActivity, binding: ActivityHomeBinding, recipesItem: List<ResultsRecipesItem?>?) {
        if(activity.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding..layoutManager = GridLayoutManager(activity, 2)
        } else {
            rv.layoutManager = LinearLayoutManager(activity)
        }
    }

    fun getDetail(param: String): ResultsDetail? {
        var recipeItem : ResultsDetail? = null
        repository.getDetailRecipes(param)
        repository.detail.observeForever { detail ->
            recipeItem = detail
        }
        return recipeItem
    }

    fun findRecipe() = repository.findRecipes("coto")
}