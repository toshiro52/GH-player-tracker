package com.example.playertracker.realm

import androidx.lifecycle.MutableLiveData
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import io.realm.Sort

class AbilityCardRealmOperations(private val config: RealmConfiguration) {
    val realm = Realm.getInstance(config)

    fun getAvailableAbilityCards(characterClass: String) = realm.where(AbilityCard::class.java)
        .equalTo("className", characterClass)
        .sort("cardReferenceNumber", Sort.ASCENDING)
        .findAll()

}