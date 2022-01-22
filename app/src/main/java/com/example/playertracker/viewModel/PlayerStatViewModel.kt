package com.example.playertracker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.playertracker.model.MAX_CHECKMARK_COUNT
import com.example.playertracker.model.MAX_LEVEL
import com.example.playertracker.model.Player
import com.example.playertracker.model.SharedPref
import kotlin.math.roundToInt
import kotlin.math.sqrt

class PlayerStatViewModel: ViewModel() {

    private val _name = MutableLiveData(getName()!!)
    val name: LiveData<String>
        get() = _name

    private val _characterClass = MutableLiveData(getClass()!!)
    val characteClass: LiveData<String>
        get() = _characterClass

    private val _level = MutableLiveData(getLevel())
    val level: LiveData<Int>
        get() = _level

    private val _experience = MutableLiveData(getExperience())
    val experience: LiveData<Int>
        get() = _experience

    private val _gold = MutableLiveData(getGold())
    val gold: LiveData<Int>
        get() = _gold

    private val _checkmarks = MutableLiveData(getCheckmarks())
    val checkmarks: LiveData<Int>
        get() = _checkmarks

    fun changeCheckmark() {
        _checkmarks.value = (_checkmarks.value)?.inc()
        Player.gainCheckmarks()
    }

    fun updateGold(input: Int) {
        _gold.value = (_gold.value)?.plus(input)
        Player.updateGold(input)
    }

    fun gainExperience(input: Int) {
        _experience.value = (_experience.value)?.plus(input)
        Player.gainExperience(input)
        _level.value = Player.getLevel()
    }

    fun getName() = Player.getName()

    fun getClass() = Player.getClass()

    fun getLevel() = Player.getLevel()

    fun getExperience() = Player.getExp()

    fun getGold() = Player.getGold()

    fun getCheckmarks() = Player.getCheckmarks()

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
        _name.value = input
        Player.setName(input)
        SharedPref.saveName(input)
    }

    fun saveClass(input: String) {
        _characterClass.value = input
        Player.setCharacterClass(input)
        SharedPref.saveClass(input)
    }

    fun saveLevel(input: Int) {
        _level.value = input
        Player.setLevel(input)
        SharedPref.saveLevel(input)
    }

    fun saveExperience(input: Int) {
        _experience.value = input
        Player.setExperience(input)
        SharedPref.saveExperience(input)
    }

    fun saveCheckmarks(input: Int) {
        _checkmarks.value = input
        Player.setCheckmarks(input)
        SharedPref.saveCheckmarks(input)
    }

    fun saveGold(input: Int) {
        _gold.value = input
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