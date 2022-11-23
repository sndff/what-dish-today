package com.c22_067.whatdishtoday.ui.home.home_fragments

import androidx.lifecycle.ViewModel
import com.c22_067.whatdishtoday.network.repository.HomeRepository

class HomeViewModel : ViewModel(){
    private val repository = HomeRepository()

    fun getAllRecipes() = repository.getRecipes()

    fun getDetail() = repository.getDetailRecipes("resep-sambal-teri-petai")

    fun findRecipe() = repository.findRecipes("coto")
}