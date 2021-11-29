package com.example.playertracker.realm

import androidx.lifecycle.MutableLiveData
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmSet

class CharacterRealmOperations(private val config: RealmConfiguration) {
    val realm = Realm.getInstance(config)
    val query = realm.where(Character::class.java)


    suspend fun createNewCharacter(
        name: String,
        level: Int = 1,
        characterClass: String,
        isRetired: Boolean = false
    ) {
        realm.executeTransaction {realmTransaction ->
            val newCharacter = Character(name = name, level = level, characterClass = characterClass, isRetired = isRetired)
            realmTransaction.insert(newCharacter)
        }
    }

    suspend fun retireCharacter(selectedAbilities: RealmSet<AbilityCard>) {
        val target = query.equalTo("isRetired", true).findFirst()

        realm.executeTransaction {
            target?.isRetired = true
            target?.selectedAbilities = selectedAbilities
        }

    }

    suspend fun getRetiredCharacters(): MutableLiveData<List<Character>> {
        val res = MutableLiveData<List<Character>>()
        val queryRes = query.equalTo("isRetired", true).findAll()
        res.value = queryRes?.subList(0, queryRes.size)
        return res
    }


}