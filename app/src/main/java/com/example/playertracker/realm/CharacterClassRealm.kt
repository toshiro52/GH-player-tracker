package com.example.playertracker.realm

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

class CharacterClass: RealmObject() {
    @PrimaryKey
    var className: String = ""
    var healthPerLevel: RealmList<Int> = RealmList()
    var handSize: Int = 0
    var perkList: RealmList<String> = RealmList()
}