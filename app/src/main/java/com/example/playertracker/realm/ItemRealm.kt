package com.example.playertracker.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Item(
    @PrimaryKey
    var cardReferenceNumber: Int? = null,
    @Required
    var cardName: String? = null,
    @Required
    var cardImageUrl: String = "",
    var isOwned: Boolean = false
) : RealmObject()