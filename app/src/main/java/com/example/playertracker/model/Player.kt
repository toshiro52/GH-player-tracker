package com.example.playertracker.model

import kotlin.math.roundToInt
import kotlin.math.sqrt

const val MAX_CHECKMARK_COUNT = 18
const val MAX_LEVEL = 9

object Player {

    private var name: String? = SharedPref.getName()
    private var characterClass: String? = SharedPref.getClass()
    private var experience: Int = SharedPref.getExperience()
    private var level: Int = SharedPref.getLevel()
    private var gold: Int = SharedPref.getGold()
    private var checkmarks = SharedPref.getCheckmarks()
    private var perkCount = SharedPref.getPerks()
    private var retiredCharacters = SharedPref.getRetiredChars()

    fun setName(newName: String) {
        name = newName
    }

    fun setCharacterClass(newCharacterClass: String) {
        characterClass = newCharacterClass
    }

    fun setLevel(newLevel: Int) {
        level = newLevel
    }

    fun setExperience(newExperience: Int) {
        experience = newExperience
    }

    fun setGold(newGold: Int) {
        gold = newGold
    }

    fun setCheckmarks(newCheckmarks: Int) {
        checkmarks = newCheckmarks
    }

    fun setPerks(newPerks: Int) {
        perkCount = newPerks
    }

    fun gainExperience(expGained: Int) {
        experience += expGained
        SharedPref.saveExperience(experience)
        updateLevel()
    }

    fun updateLevel() {
        level = ((-15 + sqrt(289 + (1.6) * experience))/2).roundToInt()
        if(level > MAX_LEVEL)
            level = MAX_LEVEL
        SharedPref.saveLevel(level)
    }

    fun updateGold(goldChange: Int) {
        if(gold + goldChange < 0)
            gold = 0
        else
            gold += goldChange
        SharedPref.saveGold(gold)
    }

    fun getName() = name

    fun getClass() = characterClass

    fun getGold() = gold

    fun getLevel() = level

    fun getExp() = experience

    fun getCheckmarks() = checkmarks

    fun getPerks() = perkCount

    fun getRetiredChars() = retiredCharacters

    fun gainCheckmarks() {
        checkmarks++
        SharedPref.saveCheckmarks(getCheckmarks())
        gainPerk()
    }


    fun gainPerk() {
        if(getCheckmarks() % 3 == 0 && getCheckmarks() <= MAX_CHECKMARK_COUNT){
            perkCount++
            SharedPref.savePerks(getPerks())
        }
    }

    fun resetCharacter() {
        resetStats()
        AttackDeck.setUpBasicAttackDeck()
    }

    fun resetStats() {
        name = ""
        level = 1
        characterClass = ""
        experience = 0
        gold = 0
        checkmarks = 0
        perkCount = 0
        SharedPref.clearPrefs()
    }

}