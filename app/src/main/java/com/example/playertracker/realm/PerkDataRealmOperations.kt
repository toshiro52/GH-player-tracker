package com.example.playertracker.realm

import io.realm.Realm
import io.realm.RealmConfiguration

class PerkDataRealmOperations(private val config: RealmConfiguration) {
    val realm = Realm.getInstance(config)

    fun getAvailablePerks(characterClass: String) = realm.where(PerkData::class.java)
        .equalTo("designatedClass", characterClass)
        .findAll()
}