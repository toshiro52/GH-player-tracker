package com.example.playertracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.playertracker.realm.AbilityCard
import com.squareup.picasso.Picasso
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter

class AbilityCardAdapter(availableAbilityCards: OrderedRealmCollection<AbilityCard?>?) : RealmRecyclerViewAdapter<AbilityCard?, AbilityCardAdapter.AbilityCardViewHolder>(availableAbilityCards, true) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbilityCardViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.ability_card_view, parent, false)
        return AbilityCardViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: AbilityCardViewHolder, position: Int) {
        val ability = getItem(position)
        holder.abilityCardName.text = ability?.cardName
        holder.initiativeValue.text = ability?.Initiative.toString()
        holder.cardLevel.text = ability?.cardLevel
        Picasso.get().load(ability?.cardImageURL).into(holder.abilityCardImage)
    }

    class AbilityCardViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val abilityCardName: TextView = view.findViewById(R.id.ability_name)
        val initiativeValue: TextView = view.findViewById(R.id.initiative_text)
        val cardLevel: TextView = view.findViewById(R.id.card_level)
        val abilityCardImage: ImageView = view.findViewById(R.id.abilityImage)
    }
}