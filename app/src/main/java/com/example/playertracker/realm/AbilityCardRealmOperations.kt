package com.example.playertracker.realm

import androidx.lifecycle.MutableLiveData
import io.realm.Realm
import io.realm.RealmConfiguration

class AbilityCardRealmOperations(private val config: RealmConfiguration) {
    val realm = Realm.getInstance(config)
    val query = realm.where(AbilityCard::class.java)

    fun getAvailableActionCards(level: Int): MutableLiveData<List<AbilityCard>> { //Level AND Class
        val res = MutableLiveData<List<AbilityCard>>()
        val queryRes = query.lessThanOrEqualTo("cardLevel", level).findAll()
        res.value = queryRes?.subList(0,queryRes.size)
        return res
    }



}