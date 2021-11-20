package com.example.playertracker.model

import com.example.playertracker.realm.AttackCard

object AttackDeck {
    val attackModifierDeck: MutableList<AttackCard> = mutableListOf()

    fun shuffleDeck() {
        attackModifierDeck.shuffle()
    }

    fun setUpBasicAttackDeck() {
        //z Realma wez wszystkie karty gdzie designatedClass == "basic"
    }

    fun addAttackCard(card: AttackCard) {
        attackModifierDeck.add(card)
    }

    fun removeAttackCard(card: AttackCard) {
        attackModifierDeck.remove(card)
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

}

// jesli obserwer bedzie chcial przetasowac, to tworzymy nowy iterator