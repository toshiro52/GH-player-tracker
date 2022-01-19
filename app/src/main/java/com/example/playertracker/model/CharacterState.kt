package com.example.playertracker.model

interface CharacterState {
    fun displayStats()
}

class RetiredState : CharacterState {
    override fun displayStats() {
        TODO("Not yet implemented")
    }
}

class ActiveState : CharacterState {
    override fun displayStats() {
        TODO("Not yet implemented")
    }
}