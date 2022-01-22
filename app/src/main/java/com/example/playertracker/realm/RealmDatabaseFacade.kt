package com.example.playertracker.realm

import io.realm.RealmConfiguration

object RealmDatabaseFacade {
    private lateinit var itemRealmOperations: ItemRealmOperations

    fun init(config: RealmConfiguration) {
        itemRealmOperations = ItemRealmOperations(config)
    }

    fun getOwnedItems() = itemRealmOperations.getOwnedItems()

    fun changeOwnedStatus(itemId: Int, ownedStatus: Boolean) {
        if(!ownedStatus)
            itemRealmOperations.changeToOwnedItem(itemId)
        else
            itemRealmOperations.changeFromOwnedItem(itemId)
    }


}