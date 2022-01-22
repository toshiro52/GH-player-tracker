package com.example.playertracker.realm

import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults

class ItemRealmOperations(private val config: RealmConfiguration) {
    private val realm = Realm.getInstance(config)

    fun getOwnedItems(): RealmResults<Item> = realm.where(Item::class.java).equalTo("isOwned", true).findAll()

    fun changeToOwnedItem(itemId: Int) { //Update Item field "isOwned" to true

        realm.executeTransaction() { r ->
            val target = r.where(Item::class.java).equalTo("cardReferenceNumber", itemId).findFirst()
            target?.isOwned = true
            realm.insertOrUpdate(target)
        }
    }

    fun changeFromOwnedItem(itemId: Int) {
        realm.executeTransaction() { r ->
            val target = r.where(Item::class.java).equalTo("cardReferenceNumber", itemId).findFirst()
            target?.isOwned = false
            realm.insertOrUpdate(target)
        }
    }

}