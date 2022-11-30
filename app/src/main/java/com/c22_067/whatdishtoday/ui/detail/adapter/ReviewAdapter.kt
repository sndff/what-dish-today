package com.c22_067.whatdishtoday.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.data.Review
import com.c22_067.whatdishtoday.databinding.ReviewBinding
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class ReviewAdapter(
    options: FirebaseRecyclerOptions<Review>,
    private val currentUserName: String?
) : FirebaseRecyclerAdapter<Review, ReviewAdapter.ReviewViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.review, parent, false)
        val binding = ReviewBinding.bind(view)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int, model: Review) {
        holder.bind(model)
    }

    inner class ReviewViewHolder(private val binding: ReviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Review) {
            binding.tvItemName.text = item.text
            Glide.with(itemView.context)
                .load(item.photoUrl)
                .circleCrop()
                .into(binding.imgItemProfil)
            binding.tvItemDescription.text = item.name
            setTextColor(item.name, binding.tvItemDescription)
        }

        private fun setTextColor(userName: String?, textView: TextView) {
            if (currentUserName == userName && userName != null) {
                textView.setBackgroundResource(R.drawable.review_teal)
            } else {
                textView.setBackgroundResource(R.drawable.review_yellow)
            }
        }
    }

}