package com.c22_067.whatdishtoday.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.databinding.ActivityDetailRecipeBinding
import com.c22_067.whatdishtoday.ui.home.home_fragments.HomeViewModel

class DetailRecipeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: ActivityDetailRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        val result = viewModel.getDetail("resep-sambal-teri-petai")

    }

    companion object {
        const val DETAIL_RECIPE = "key"
    }
}