package com.c22_067.whatdishtoday.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.model.ModelKategori

class KategoriAdapter(private val context: Context, private val modelCategories: List<ModelKategori>) :
        RecyclerView.Adapter<KategoriAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_kategori, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = modelCategories[position]
        holder.tvCategories.text = data.strKategori
        holder.relativeCategories.setOnClickListener {
            val intent = Intent(context, ListKategoriActivity::class.java)
            intent.putExtra(ListKategoriActivity.LIST_CATEGORIES, modelCategories[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return modelCategories.size
    }

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var relativeCategories: RelativeLayout
        var tvCategories: TextView

        init {
            relativeCategories = itemView.findViewById(R.id.tab_kategori)
            tvCategories = itemView.findViewById(R.id.tv_kategori)
        }
    }
}