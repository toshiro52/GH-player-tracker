package com.example.playertracker.realm

import io.realm.Realm
import io.realm.RealmConfiguration

class AttackCardOperations(private val config: RealmConfiguration) {
    val realm = Realm.getInstance(config)

    fun getAttackCard(attackValue: String, characterClass: String) = realm.where(AttackCard::class.java)
        .equalTo("designatedClass", characterClass)
        .equalTo("attackValue", attackValue)
        .findFirst()!!

}