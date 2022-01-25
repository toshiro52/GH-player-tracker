package com.example.playertracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.playertracker.realm.Item
import com.squareup.picasso.Picasso
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter

class ItemCardAdapter(ownedItems: OrderedRealmCollection<Item?>?) : RealmRecyclerViewAdapter<Item?, ItemCardAdapter.ItemCardViewHolder?>(ownedItems, true) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemCardAdapter.ItemCardViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_card_view, parent, false)
        return ItemCardViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemCardAdapter.ItemCardViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemName.text = item?.cardName
        Picasso.get().load("file:///android_asset/item/${item?.cardImageUrl}.png").into(holder.itemImage)
    }

    class ItemCardViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.itemImage)
        val itemName: TextView = view.findViewById(R.id.itemName)
    }
}