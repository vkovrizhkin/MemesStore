package com.kovrizhkin.memesstore.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kovrizhkin.memesstore.App
import com.kovrizhkin.memesstore.R
import com.kovrizhkin.memesstore.model.memes.MemInfo
import kotlinx.android.synthetic.main.mem_item_layout.view.*
import java.util.zip.Inflater

class MemRecViewAdapter(
    var memesList: List<MemInfo>,
    val onItemClick: (MemInfo) -> Any
) :
    RecyclerView.Adapter<MemRecViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(App.getContext()).inflate(R.layout.mem_item_layout, parent, false)

        return ViewHolder(view)
    }


    override fun getItemCount(): Int = memesList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mem = memesList[position]

        holder.container.setOnClickListener { onItemClick(mem) }

        Glide.with(App.getContext()!!)
            .load(mem.photoUtl)
            .placeholder(R.drawable.ic_crop_original_white_24dp)
            .into(holder.image)

        holder.label.text = mem.title
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.image!!
        val label = view.labelText!!
        val container = view

        val favoriteButton = view.favoriteButton!!
        val shareButton = view.shareButton!!

    }
}