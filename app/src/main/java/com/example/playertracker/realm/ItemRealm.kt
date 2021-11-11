package com.example.playertracker.realm

import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class ItemRealm(
    @PrimaryKey
    var cardReferenceNumber: Int = 0,
    @Required
    var itemType: ITEM_TYPE? = null,
    @Required
    var cardGraphicUrl: String = ""
) {
}


enum class ITEM_TYPE {
    SCOUNDREL, BRUTE, TINKERER, MINDTHIEF, CRAIGHEART, SPELLWEAVER
}