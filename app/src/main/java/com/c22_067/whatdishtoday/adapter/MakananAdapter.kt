package com.c22_067.whatdishtoday.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c22_067.whatdishtoday.databinding.ItemRvMainCategoryBinding
import com.dicoding.picodiploma.homerecipe.datasource.Makanan

class MakananAdapter : RecyclerView.Adapter<MakananAdapter.MakananViewHolder>() {
    private val list = ArrayList<Makanan>()
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setList(makanan: ArrayList<Makanan>) {
        list.clear()
        list.addAll(makanan)
        notifyDataSetChanged() //DiffUtil?
    }

    inner class MakananViewHolder(private val binding: ItemRvMainCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(makanan: Makanan) {
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClicked(makanan)
            }
            binding.apply {
                tvDishName.text = makanan.key
                imgDish. = makanan.thumb

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakananViewHolder {
        val view = ItemRvMainCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder((view))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}