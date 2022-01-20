package com.example.playertracker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.playertracker.model.MAX_CHECKMARK_COUNT
import com.example.playertracker.model.Player
import com.example.playertracker.model.SharedPref

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
    }

    fun getName() = Player.getName()

    fun getClass() = Player.getClass()

    fun getLevel() = Player.getLevel()

    fun getExperience() = Player.getExp()

    fun getGold() = Player.getGold()

    fun getCheckmarks() = Player.getCheckmarks()

}