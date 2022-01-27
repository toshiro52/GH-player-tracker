package com.example.playertracker.viewModel

import androidx.lifecycle.ViewModel
import com.example.playertracker.model.AttackDeck
import com.example.playertracker.realm.PerkData
import com.example.playertracker.realm.RealmDatabaseFacade

class PerkViewModel : ViewModel() {

    fun updatePerkStatus(perkData: PerkData) {
        RealmDatabaseFacade.updatePerkStatus(perkData.perkCode)
        parsePerkCode(perkData.perkCode, perkData.designatedClass)
    }

    fun parsePerkCode(perkCode: String, characterClass: String) {
        val start = perkCode.indexOf('|')
        val end = perkCode.indexOf('|', start + 1)
        when(perkCode[0]) {
            'A' -> AttackDeck.addAttackCard(perkCode.substring(start+1, end), perkCode[1].toString().toInt(), characterClass)
            'R' -> AttackDeck.removeAttackCard(perkCode.substring(start+1, end), perkCode[1].toString().toInt(), "Basic")
        }
        if(end+1 != perkCode.length) {
            parsePerkCode(perkCode.substring(end+1, perkCode.length), characterClass)
        }

    }
}