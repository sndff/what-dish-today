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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import okhttp3.internal.notify
import okhttp3.internal.notifyAll
import java.lang.ref.Reference
import java.util.*

class ReviewFragment : Fragment() {

    private lateinit var binding: FragmentReviewBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseReference
    private lateinit var adapter: ReviewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentReviewBinding.inflate(inflater)

        val layoutManager = LinearLayoutManager(context)
        layoutManager.stackFromEnd = true
        binding.rvResep.layoutManager = layoutManager

        db = Firebase.database.getReference("review")

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth
        val firebaseUser = auth.currentUser

        val key = requireArguments().getString("key")

        val messagesRef = db.child(key!!)
        // buat nge filter review per makanan set key nya dari sini
        // buat id/kenya harusnya udah masuk ke database


        binding.progressBar.visibility = View.GONE

        val options = FirebaseRecyclerOptions.Builder<Review>()
            .setQuery(messagesRef, Review::class.java)
            .setLifecycleOwner(this)
            .build()

        adapter = ReviewAdapter(options, firebaseUser?.displayName)
        binding.rvResep.adapter = adapter

        binding.sendButton.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            if(binding.messageEditText.text.toString() != "") {
                val friendlyReview = Review(
                    key, // ini id untuk makanan, tiap review harusnya ada dalam 1 database yang sama tapi id ini yang membedakan review diantara semua makanan
                    binding.messageEditText.text.toString(),
                    firebaseUser?.displayName.toString(),
                    firebaseUser?.photoUrl.toString(),
                    Date().time
                )
                messagesRef.push().setValue(friendlyReview) { error, _ ->
                    if (error != null) {
                        Toast.makeText(context,getString(R.string.send_error) + error.message,Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context,getString(R.string.send_success),Toast.LENGTH_SHORT).show()
                    }
                }
                binding.progressBar.visibility = View.GONE
                binding.messageEditText.setText("")
            } else {
                Toast.makeText(context,"Field review tidak boleh kosong",Toast.LENGTH_SHORT).show()
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.startListening()
    }

    fun launchFragment(key: String?): ReviewFragment {
        val fragment = ReviewFragment()
        val bundle = Bundle().apply {
            putString("key", key)
        }
        fragment.arguments = bundle

        return fragment
    }
}