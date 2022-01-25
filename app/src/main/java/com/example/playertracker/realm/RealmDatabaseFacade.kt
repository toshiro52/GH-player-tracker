package com.example.playertracker.realm

import com.example.playertracker.model.Player
import io.realm.RealmConfiguration

object RealmDatabaseFacade {
    private lateinit var itemRealmOperations: ItemRealmOperations
    private lateinit var abilityCardRealmOpeations: AbilityCardRealmOperations
    private lateinit var attackCardOperations: AttackCardOperations

    fun init(config: RealmConfiguration) {
        itemRealmOperations = ItemRealmOperations(config)
        abilityCardRealmOpeations = AbilityCardRealmOperations(config)
        attackCardOperations = AttackCardOperations(config)
    }

    fun getOwnedItems() = itemRealmOperations.getOwnedItems()

    fun changeOwnedStatus(itemId: Int, ownedStatus: Boolean) {
        if(!ownedStatus)
            itemRealmOperations.changeToOwnedItem(itemId)
        else
            itemRealmOperations.changeFromOwnedItem(itemId)
    }

    fun getAvailableAbilitiCards() = abilityCardRealmOpeations.getAvailableAbilityCards(Player.getClass()!!)

    fun getAttackCard(attackValue: String, characterClass: String) = attackCardOperations.getAttackCard(attackValue, characterClass)


}