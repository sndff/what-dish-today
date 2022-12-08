package com.c22_067.whatdishtoday.ui.detail

import androidx.lifecycle.ViewModel
import com.c22_067.whatdishtoday.network.repository.MainRepository
import com.c22_067.whatdishtoday.network.responses.ResultsDetail

class DetailViewModel: ViewModel() {
    val repository = MainRepository()
    var detail: ResultsDetail? = null

    fun getDetail(key: String) {
        repository.getDetailRecipes(key)
        repository.detail.observeForever {
            detail = it
        }
    }
}