package com.example.playertracker.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class AbilityCardRealm(
    @PrimaryKey
    var cardReferenceNumber: Int = 0,
    @Required
    var className: String = "",
    var cardLevel: String = "",
    var Initiative: Int = 0,
    @Required
    var cardImageURL: String? = null
) : RealmObject() {

}