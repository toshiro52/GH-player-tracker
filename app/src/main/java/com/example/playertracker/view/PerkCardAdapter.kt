package com.example.playertracker.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.playertracker.R
import com.example.playertracker.realm.PerkData
import com.google.android.material.checkbox.MaterialCheckBox
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter

class PerkCardAdapter(
    availablePerks: OrderedRealmCollection<PerkData?>?,
    private val itemClickListener: (perkData: PerkData) -> Unit
        ): RealmRecyclerViewAdapter<PerkData?, PerkCardAdapter.PerkCardViewHolder>(availablePerks, true) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PerkCardViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.perk_card_view, parent, false)
        return PerkCardViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: PerkCardViewHolder, position: Int) {
        val item = getItem(position)
        holder.checkBox.text = item?.perkText
        holder.checkBox.isChecked = item?.isSelected!!
        holder.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                holder.checkBox.isClickable = false
                itemClickListener(item)
            }
            else {
                holder.checkBox.isClickable = true
            }
        }
    }

    class PerkCardViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val checkBox: MaterialCheckBox = view.findViewById(R.id.perkCheckbox)
    }

}