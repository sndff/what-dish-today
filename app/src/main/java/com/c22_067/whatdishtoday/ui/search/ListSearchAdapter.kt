package com.c22_067.whatdishtoday.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c22_067.whatdishtoday.databinding.ItemSearchBinding


class ListSearchAdapter (private  val listData: ArrayList<TempDataSearch>) : RecyclerView.Adapter<ListSearchAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemSearchBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name) = listData[position]
        holder.binding.tvItemName.text = name
    }

    override fun getItemCount(): Int = listData.size
}