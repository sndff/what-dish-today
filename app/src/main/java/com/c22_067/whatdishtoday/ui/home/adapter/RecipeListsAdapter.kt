package com.c22_067.whatdishtoday.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.network.responses.ResultsRecipesItem

class RecipeListsAdapter(private val list: List<ResultsRecipesItem?>?) : RecyclerView.Adapter<RecipeListsAdapter.ViewHolder>() {

    private lateinit var onItemClick: OnItemClick

    interface OnItemClick: AdapterView.OnItemClickListener{
        fun onItemClicked(data: ResultsRecipesItem?)
    }
    
    fun setOnItemClickCallback(onItemClick: OnItemClick){
        this.onItemClick = onItemClick
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var ivRecipeImage: ImageView = itemView.findViewById(R.id.iv__dish)
        var tvRecipeName: TextView = itemView.findViewById(R.id.tv_main_dish_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category, parent, false)
        return ViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val img = list?.get(position)?.thumb
        val name = list?.get(position)?.title
        Glide.with(holder.itemView.context)
            .load(img)
            .into(holder.ivRecipeImage)
        holder.tvRecipeName.text = name
        
        holder.itemView.setOnClickListener { 
            onItemClick.onItemClicked(list!![holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = list!!.size

}