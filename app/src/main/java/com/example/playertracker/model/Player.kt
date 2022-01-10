package com.example.playertracker.model

import kotlin.math.roundToInt
import kotlin.math.sqrt

const val MAX_CHECKMARK_COUNT = 18
const val MAX_LEVEL = 9

object Player {
    private var name: String = "" //Realm
    private var characterClass: String = "" //Realm
    private var experience: Int = 0 //sharedPref
    private var level: Int = 1 //Realm
    private var gold: Int = 0 //sharedPref
    private var checkmarks = 0 //sharedPref
    private var perkCount = 0 //sharedPref

    //var selectedAbilities: Set<AbilityCard> = setOf()// Jak bardzo potrzebne skoro w bazie jest to trzymane

    fun changeExperience(expGained: Int) {
        experience += expGained
        updateLevel()
    }

    fun updateLevel() {
        level = ((-15 + sqrt(289 + (1.6) * experience))/2).roundToInt()
        if(level > MAX_LEVEL)
            level = MAX_LEVEL
    }

    fun updateGold(goldChange: Int) {
        if(gold + goldChange < 0)
            gold = 0
        else
            gold += goldChange
    }

    fun gainCheckmarks() {
        checkmarks++
        updatePerkCount()
    }

    fun updatePerkCount() {
        if(checkmarks % 3 == 0 && checkmarks <= MAX_CHECKMARK_COUNT)
            perkCount++
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
    }
}