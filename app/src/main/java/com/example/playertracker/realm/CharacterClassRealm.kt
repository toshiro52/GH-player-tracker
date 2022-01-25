package com.example.playertracker.realm

import io.realm.RealmObject
import io.realm.RealmList
import io.realm.annotations.Required
import io.realm.annotations.PrimaryKey

open class CharacterClass : RealmObject() {

    @PrimaryKey
    var className: String = ""
    var handSize: Long = 0
    var perkList: RealmList<String>? = null
    @Required
    var perkCodeList: RealmList<String> = RealmList()

}