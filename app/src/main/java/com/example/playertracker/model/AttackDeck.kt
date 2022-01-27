package com.example.playertracker.model

import android.util.Log
import com.example.playertracker.realm.AttackCard
import com.example.playertracker.realm.RealmDatabaseFacade

object AttackDeck {
    val attackModifierDeck: MutableList<AttackCard> = mutableListOf()
    var deckState: AttackDeckState = RegularDeckState()

    fun shuffleDeck() {
        attackModifierDeck.shuffle()
    }

    fun changeDeckState(needsShuffle: Boolean) {
        deckState = when(needsShuffle) {
            true -> ShuffleDeckState()
            false -> RegularDeckState()
        }
    }

    fun setUpBasicAttackDeck() {
        attackModifierDeck.clear()
        addAttackCard("+0", 6, "Basic")
        addAttackCard("+1", 5, "Basic")
        addAttackCard("+2", 1, "Basic")
        addAttackCard("-1", 5, "Basic")
        addAttackCard("-2", 1, "Basic")
        addAttackCard("MISS", 1, "Basic")
        addAttackCard("2x", 1, "Basic")
        shuffleDeck()
    }

    fun addAttackCard(cardValue: String, occurrences: Int, characterClass: String) {
        val card = RealmDatabaseFacade.getAttackCard(cardValue, characterClass)
        for(i in 1..occurrences) {
            attackModifierDeck.add(card)
        }
        Log.d("TAG", "Deck size: ${attackModifierDeck.size}")
    }

    fun removeAttackCard(cardValue: String, occurrences: Int, characterClass: String) {
        for(i in 1..occurrences) {
            attackModifierDeck.removeAt(attackModifierDeck.indexOfFirst { it.designatedClass == characterClass && it.attackValue == cardValue })
        }
        Log.d("TAG", "Deck size: ${attackModifierDeck.size}")
    }

    fun createIterator() = AttackDeckIterator(this)

}

class AttackDeckIterator(private val collection: AttackDeck) {
    private var index = 0

    fun next(): AttackCard {
        return collection.attackModifierDeck[index++]
    }

    fun hasNext(): Boolean {
        return index < collection.attackModifierDeck.size
    }

    fun reset() {
        index = 0
    }

}