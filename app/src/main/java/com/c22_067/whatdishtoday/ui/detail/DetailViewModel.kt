package com.c22_067.whatdishtoday.ui.detail

import android.content.Context
import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import com.c22_067.whatdishtoday.databinding.FragmentDirectionsBinding
import com.c22_067.whatdishtoday.databinding.FragmentIngridientsBinding
import com.c22_067.whatdishtoday.network.repository.MainRepository
import com.c22_067.whatdishtoday.network.responses.ResultsDetail

class DetailViewModel(context: Context): ViewModel() {
    private val repository = MainRepository()
    private var bindingIngridientsFragment = FragmentIngridientsBinding.inflate(LayoutInflater.from(context))
    private var bindingStepFragment = FragmentDirectionsBinding.inflate(LayoutInflater.from(context))

    fun getDetail(key: String) {
        repository.getDetailRecipes(key)
        repository.detail.observeForever {

        }
    }
}