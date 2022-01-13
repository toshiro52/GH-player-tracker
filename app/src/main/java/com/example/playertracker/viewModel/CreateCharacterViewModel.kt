package com.example.playertracker.viewModel

import androidx.lifecycle.ViewModel
import com.example.playertracker.model.Player

class CreateCharacterViewModel : ViewModel() {

    fun validateLevelInput(input: String): Boolean = !input.isNullOrEmpty() && input.toInt() in (1..9)

    fun validateNameInput(input: String): Boolean = !input.isNullOrEmpty()

    fun saveCharacter(characterName: String, characterClass: String, level: Int) {
        Player.resetStats()
        Player.setName(characterName)
        Player.setCharacterClass(characterClass)
        Player.setLevel(level)
        //Player.setUpPerks()
        //Player.loadAbilityCards()

    }

    fun calculateStartingGold(inputLevel: Int) = 15*(inputLevel+1)
}