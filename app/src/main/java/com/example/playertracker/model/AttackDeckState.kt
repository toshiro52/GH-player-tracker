package com.example.playertracker.model

interface AttackDeckState {
    val needsShuffle: Boolean

    fun displayMessage(): String
}

class ShuffleDeckState : AttackDeckState {
    override val needsShuffle: Boolean = true

    override fun displayMessage() = "Shuffle Deck!"

}

class RegularDeckState : AttackDeckState {
    override val needsShuffle = false

    override fun displayMessage() = ""

}