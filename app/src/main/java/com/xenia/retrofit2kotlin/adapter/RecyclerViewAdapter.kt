package com.xenia.retrofit2kotlin.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.xenia.retrofit2kotlin.R
import com.xenia.retrofit2kotlin.model.Cat
import com.xenia.retrofit2kotlin.model.Owner

class RecyclerViewAdapter(
    private var listOwners: List<Owner>,
    private var listCats: List<Cat>
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewItem)
        val textView: TextView = itemView.findViewById(R.id.textViewItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOwners.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refresh(cats: List<Cat>, owners: List<Owner>) {
        this.listCats = cats
        this.listOwners = owners
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ownerItem = listOwners[position]
        val catItem = listCats[position]

        val picasso = Picasso.get()
        picasso.load(catItem.url).into(holder.imageView)

        // sets the text to the textview from our itemHolder class
        val nameOwner = "${ownerItem.firstName} ${ownerItem.lastName}"
        holder.textView.text = nameOwner
    }
}