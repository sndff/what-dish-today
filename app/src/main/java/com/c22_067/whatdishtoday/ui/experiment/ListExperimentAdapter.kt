package com.c22_067.whatdishtoday.ui.experiment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c22_067.whatdishtoday.databinding.ItemExperimentBinding

class ListExperimentAdapter(private val listExperiment: ArrayList<Experiment>) : RecyclerView.Adapter<ListExperimentAdapter.ListViewHolder>(){
    class ListViewHolder(var binding: ItemExperimentBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemExperimentBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo, name) = listExperiment[position]
        holder.binding.ivItemExperiment.setImageResource(photo)
        holder.binding.tvItemExperiment.text = name
    }

    override fun getItemCount(): Int = listExperiment.size
}