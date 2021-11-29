package com.example.playertracker.realm

import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject

class CharacterClassRealmOperations(private val config: RealmConfiguration ) {
    val realm = Realm.getInstance(config)
    val query = realm.where(CharacterClass::class.java)

    suspend fun getCharacterClassInfo(className: String): CharacterClass? {
        return query.equalTo("className", className).findFirst()
    }

}