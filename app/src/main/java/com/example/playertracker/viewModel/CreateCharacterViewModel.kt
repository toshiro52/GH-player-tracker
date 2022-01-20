package com.example.playertracker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.playertracker.model.Player
import com.example.playertracker.model.SharedPref


class CreateCharacterViewModel : ViewModel() {

    fun validateLevelInput(input: String): Boolean = !input.isNullOrEmpty() && input.toInt() in (1..9)

    fun validateNameInput(input: String): Boolean = !input.isNullOrEmpty()

    fun saveCharacter(characterName: String, characterClass: String, level: Int) {
        saveName(characterName)
        saveClass(characterClass)
        saveLevel(level)
        saveGold(calculateStartingGold(level))
        saveExperience(calculateStartingExperience(level).toInt())
        saveCheckmarks(calculateStartingCheckmarks(level))
        savePerks(calculateStartingPerks(level))
    }

    fun saveName(input: String) {
        Player.setName(input)
        SharedPref.saveName(input)
    }

    fun saveClass(input: String) {
        Player.setCharacterClass(input)
        SharedPref.saveClass(input)
    }

    fun saveLevel(input: Int) {
        Player.setLevel(input)
        SharedPref.saveLevel(input)
    }

    fun saveExperience(input: Int) {
        Player.setExperience(input)
        SharedPref.saveExperience(input)
    }

    fun saveCheckmarks(input: Int) {
        Player.setCheckmarks(input)
        SharedPref.saveCheckmarks(input)
    }

    fun saveGold(input: Int) {
        Player.setGold(input)
        SharedPref.saveGold(input)
    }

    fun savePerks(input: Int) {
        Player.setPerks(input)
        SharedPref.savePerks(input)
    }

    fun calculateStartingGold(inputLevel: Int) = 15*(inputLevel+1)

    fun calculateStartingExperience(inputLevel: Int) = 2.5*(inputLevel*inputLevel) + 37.5*inputLevel-40

    fun calculateStartingCheckmarks(inputLevel: Int) = Player.getRetiredChars() + inputLevel - 1 // Do viewModel

    fun calculateStartingPerks(inputLevel: Int) = calculateStartingCheckmarks(inputLevel) % 3

}