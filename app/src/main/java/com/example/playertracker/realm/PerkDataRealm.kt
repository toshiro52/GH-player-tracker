package com.example.playertracker.realm

import io.realm.RealmObject

open class PerkData : RealmObject() {

    var designatedClass: String = ""
    var perkText: String = ""
    var perkCode: String = ""
    var isSelected: Boolean = false

}
