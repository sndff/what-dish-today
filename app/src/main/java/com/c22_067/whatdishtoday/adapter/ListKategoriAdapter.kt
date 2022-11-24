package com.c22_067.whatdishtoday.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.model.ModelMakanan
import com.c22_067.whatdishtoday.ui.detail.DetailMenuActivity

class ListKategoriAdapter(private val context: Context, private val modelListCategories: List<ModelMakanan>) :
        RecyclerView.Adapter<ListKategoriAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_makanan, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = modelListCategories[position]
        Glide.with(context)
                .load(data.strThumbnail)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageThumbnail)
        holder.tvTitleRecipe.text = data.strTitleResep
        holder.cvListRecipe.setOnClickListener {
            val intent = Intent(context, DetailMenuActivity::class.java)
//            intent.putExtra(DetailMenuActivity.DETAIL_RECIPES, modelListCategories[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return modelListCategories.size
    }

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cvListRecipe: CardView
        var imageThumbnail: ImageView
        var tvTitleRecipe: TextView

        init {
            cvListRecipe = itemView.findViewById(R.id.cv_list_makanan)
            imageThumbnail = itemView.findViewById(R.id.img_makanan)
            tvTitleRecipe = itemView.findViewById(R.id.tv_title_makanan)
        }
    }
}