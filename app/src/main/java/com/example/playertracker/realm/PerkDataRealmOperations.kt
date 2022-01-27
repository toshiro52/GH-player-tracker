package com.example.playertracker.realm

import io.realm.Realm
import io.realm.RealmConfiguration

class PerkDataRealmOperations(private val config: RealmConfiguration) {
    val realm = Realm.getInstance(config)

    fun getAvailablePerks(characterClass: String) = realm.where(PerkData::class.java)
        .equalTo("designatedClass", characterClass)
        .findAll()

    fun updatePerkStatus(characterClass: String, perkCode: String) {
        realm.executeTransaction { r ->
            val target = r.where(PerkData::class.java)
                .equalTo("designatedClass", characterClass)
                .equalTo("perkCode", perkCode)
                .findFirst()
            target?.isSelected = true
            r.insertOrUpdate(target)
        }
    }

    fun resetPerks() {
        realm.executeTransaction { r ->
            val target = r.where(PerkData::class.java)
                .equalTo("isSelected", true)
                .findAll()
            target.setBoolean("isSelected", false)
        }
    }

}