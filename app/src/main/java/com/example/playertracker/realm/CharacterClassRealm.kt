package com.example.playertracker.realm

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CharacterClass: RealmObject() {
    @PrimaryKey
    var className: String = ""
    //var healthPerLevel: RealmList<Int> = RealmList() -> Nie ma sensu, nie ma pola do pokazania tego
    var handSize: Int = 0
    var perkList: RealmList<String> = RealmList()
}