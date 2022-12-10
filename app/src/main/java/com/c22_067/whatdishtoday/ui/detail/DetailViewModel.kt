package com.c22_067.whatdishtoday.ui.detail

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.data.FavoriteModel
import com.c22_067.whatdishtoday.data.ReviewModel
import com.c22_067.whatdishtoday.network.repository.MainRepository
import com.c22_067.whatdishtoday.network.responses.ResultsDetail
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import java.util.*

class DetailViewModel: ViewModel() {
    val repository = MainRepository()
    var detail: ResultsDetail? = null

    fun getDetail(key: String) {
        repository.getDetailRecipes(key)
        repository.detail.observeForever {
            detail = it
        }
    }

    fun addfavorite(key: String,name:String,photo:String, id: String, db:DatabaseReference){

//        val auth = Firebase.auth
//        val firebaseUser = auth.currentUser
        val messagesRef = db.child(id)
        val favorite = FavoriteModel(
            key,name,photo
        )
        messagesRef.push().setValue(favorite) { error, _ ->
//            if (error != null) {
//                Toast.makeText(context,getString(R.string.send_error) + error.message, Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(context,getString(R.string.send_success), Toast.LENGTH_SHORT).show()
//            }
        }
    }
}