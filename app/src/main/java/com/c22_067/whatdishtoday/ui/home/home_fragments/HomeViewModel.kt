package com.c22_067.whatdishtoday.ui.home.home_fragments

import androidx.lifecycle.ViewModel
import com.c22_067.whatdishtoday.network.repository.HomeRepository
import com.c22_067.whatdishtoday.network.responses.ResultsDetail
import com.c22_067.whatdishtoday.network.responses.ResultsRecipesItem

class HomeViewModel : ViewModel(){
    private val repository = HomeRepository()

    fun getAllRecipes(): List<ResultsRecipesItem?>? {
        var recipesItem : List<ResultsRecipesItem?>? = null
        repository.getRecipes()
        repository.recipe.observeForever { recipe ->
            recipesItem = recipe
        }
        return recipesItem
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