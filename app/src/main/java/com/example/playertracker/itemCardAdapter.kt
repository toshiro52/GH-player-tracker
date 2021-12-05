package com.example.playertracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.playertracker.realm.Item
import com.squareup.picasso.Picasso

class ItemCardAdapter(private val ownedItems: List<Item>) : RecyclerView.Adapter<ItemCardAdapter.ItemCardViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemCardAdapter.ItemCardViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_card_view, parent, false)
        return ItemCardViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemCardAdapter.ItemCardViewHolder, position: Int) {
        val item = ownedItems[position]
        holder.itemName.text = item.cardName
        //holder.itemDesc.text = item.cardDesc
        Picasso.get().load(item.cardImageUrl).into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        return ownedItems.size
    }

    class ItemCardViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.itemImage)
        val itemName: TextView = view.findViewById(R.id.itemName)
        //val itemDesc: TextView = view.findViewById(R.id.itemDesc)
    }
}