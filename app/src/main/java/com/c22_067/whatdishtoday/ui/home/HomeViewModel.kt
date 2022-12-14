package com.c22_067.whatdishtoday.ui.home

import android.content.Intent
import android.content.res.Configuration
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.c22_067.whatdishtoday.ui.home.adapter.RecipeListsAdapter
import com.c22_067.whatdishtoday.databinding.ActivityHomeBinding
import com.c22_067.whatdishtoday.network.repository.MainRepository
import com.c22_067.whatdishtoday.network.responses.ResultsRecipesItem
import com.c22_067.whatdishtoday.ui.detail.activity.DetailMenuActivity

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
                showSelectedRecipe(activity, data)
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

    private fun showSelectedRecipe(activity: AppCompatActivity, list: ResultsRecipesItem?) {
        val intent = Intent(activity, DetailMenuActivity::class.java)
        intent.putExtra(DetailMenuActivity.KEY, list?.key)
        intent.putExtra(DetailMenuActivity.NAME, list?.title)
        intent.putExtra(DetailMenuActivity.PHOTO, list?.thumb)
        activity.startActivity(intent)
    }
}