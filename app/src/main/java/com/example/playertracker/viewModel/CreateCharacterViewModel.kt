package com.example.playertracker.viewModel

import androidx.lifecycle.ViewModel
import com.example.playertracker.model.Player


class CreateCharacterViewModel : ViewModel() {

    fun validateLevelInput(input: String): Boolean = !input.isNullOrEmpty() && input.toInt() in (1..9)

    fun validateNameInput(input: String): Boolean = !input.isNullOrEmpty()

    fun saveCharacter(characterName: String, characterClass: String, level: Int) {

    }

    fun calculateStartingGold(inputLevel: Int) = 15*(inputLevel+1)

    fun saveName() {

    }

    fun saveClass() {

    }

    fun saveLevel() {

    }

    fun saveExperience() {

    }

    fun saveCheckmarks() {

    }

    fun saveGold() {

    }

    fun savePerks() {

    }
}