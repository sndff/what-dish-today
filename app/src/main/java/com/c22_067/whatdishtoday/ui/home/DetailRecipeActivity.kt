package com.c22_067.whatdishtoday.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.model.HomeViewModel

class DetailRecipeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_recipe)

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        viewModel.getDetail()
        viewModel.findRecipe()
    }
}