package com.example.playertracker.realm

import androidx.lifecycle.MutableLiveData
import io.realm.Realm
import io.realm.RealmConfiguration

class ItemRealmOperations(private val config: RealmConfiguration) {
    val realm = Realm.getInstance(config)
    val query = realm.where(Item::class.java)

    suspend fun getOwnedItems(): MutableLiveData<List<Item>> {
        val res = MutableLiveData<List<Item>>()
        val queryRes = query.equalTo("isOwned", true).findAll()
        res.value = queryRes?.subList(0, queryRes.size)
        return res
    }

    suspend fun changeToOwnedItem(cardReferenceNumber: Int) { //Update Item field "isOwned" to true
        val target = query.equalTo("cardReferenceNumber", cardReferenceNumber).findFirst()

        realm.executeTransaction() {
            target?.isOwned = true
            realm.insertOrUpdate(target)
        }
    }

    suspend fun changeFromOwnedItem(cardReferenceNumber: Int) {
        val target = query.equalTo("cardReferenceNumber", cardReferenceNumber).findFirst()

        realm.executeTransaction() {
            target?.isOwned = false
            realm.insertOrUpdate(target)
        }
    }

}