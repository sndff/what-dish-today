package com.c22_067.whatdishtoday.ui.detail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.data.Review
import com.c22_067.whatdishtoday.databinding.FragmentReviewBinding
import com.c22_067.whatdishtoday.ui.detail.adapter.ReviewAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class ReviewFragment : Fragment() {

    private lateinit var binding: FragmentReviewBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseDatabase
    private lateinit var adapter: ReviewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentReviewBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth
        val firebaseUser = auth.currentUser

        db = Firebase.database
        val messagesRef = db.reference.child(MESSAGES_CHILD)

        binding.sendButton.setOnClickListener {
            val friendlyReview = Review(
                binding.messageEditText.text.toString(),
//                firebaseUser?.tenantId.toString(),
                firebaseUser?.displayName.toString(),
                firebaseUser?.photoUrl.toString(),
                Date().time
            )
            messagesRef.push().setValue(friendlyReview) { error, _ ->
                if (error != null) {
                    Toast.makeText(context, getString(R.string.send_error) + error.message, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, getString(R.string.send_success), Toast.LENGTH_SHORT).show()
                }
            }
            binding.messageEditText.setText("")
        }

        val manager = LinearLayoutManager(context)
        manager.stackFromEnd = true
        binding.rvResep.layoutManager = manager

        val options = FirebaseRecyclerOptions.Builder<Review>()
            .setQuery(messagesRef, Review::class.java)
            .build()
        adapter = ReviewAdapter(options, firebaseUser?.displayName)
        binding.rvResep.adapter = adapter

    }

    override fun onResume() {
        super.onResume()
        adapter.startListening()
    }

    override fun onPause() {
        adapter.stopListening()
        super.onPause()
    }

//    private fun Loading(state: Boolean) {
//        if (state) {
//            binding.progressBar.show()
//        } else {
//            binding.progressBar.hide()
//        }
//    }

    companion object {
        const val MESSAGES_CHILD = "messages"
    }
}