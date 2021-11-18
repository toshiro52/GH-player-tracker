package com.example.playertracker.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class PerkCard(
    @PrimaryKey
    var cardReferenceNumber: Int = 0,
    @Required
    var perkValue: String = "",
    @Required
    var designatedClass: String = "", // for what character class is the perk
    @Required
    var cardImageUrl: String = ""
) : RealmObject() {
}