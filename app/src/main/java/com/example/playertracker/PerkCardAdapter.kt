package com.example.playertracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.checkbox.MaterialCheckBox
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter

class PerkCardAdapter(availablePerks: OrderedRealmCollection<String?>?) : RealmRecyclerViewAdapter<?, PerkCardAdapter.PerkViewHolder>(availablePerks, true) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PerkViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.perk_card_view, parent, false)
        return PerkViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: PerkViewHolder, position: Int) {
        val perk = getItem(position)
    }




    class PerkViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        var checkBox: MaterialCheckBox = view.findViewById(R.id.perkCheckbox)
    }
}