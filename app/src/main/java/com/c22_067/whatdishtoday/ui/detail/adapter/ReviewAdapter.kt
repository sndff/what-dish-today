package com.c22_067.whatdishtoday.ui.detail.adapter

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.data.ReviewModel
import com.c22_067.whatdishtoday.databinding.ItemReviewBinding
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class ReviewAdapter(
    options: FirebaseRecyclerOptions<ReviewModel>,
    private val currentUserName: String?
) : FirebaseRecyclerAdapter<ReviewModel, ReviewAdapter.ReviewViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_review, parent, false)
        val binding = ItemReviewBinding.bind(view)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int, model: ReviewModel) {
        holder.bind(model)
    }

    inner class ReviewViewHolder(private val binding: ItemReviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ReviewModel) {
            binding.tvItemName.text = item.name
            Glide.with(itemView.context)
                .load(item.photoUrl)
                .apply(RequestOptions().override(70, 70))
                .circleCrop()
                .into(binding.imgItemProfil)
            binding.tvItemDescription.text = item.text
            setTextColor(item.text, binding.tvItemDescription)
            binding.tvTimestamp.text = item.timestamp?.let { DateUtils.getRelativeTimeSpanString(it) }
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