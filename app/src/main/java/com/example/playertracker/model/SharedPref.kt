package com.example.playertracker.model

import android.content.Context
import android.content.SharedPreferences

object SharedPref{
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context){
        sharedPreferences = context.getSharedPreferences("playerData", Context.MODE_PRIVATE)
    }

    fun clearPrefs() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.commit()
    }

    fun saveName(input: String) {
        val editor = sharedPreferences.edit()
        editor.putString("name", input)
        editor.commit()
    }

    fun saveClass(input: String) {
        val editor = sharedPreferences.edit()
        editor.putString("class", input)
        editor.commit()
    }

    fun saveLevel(input: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt("level", input)
        editor.commit()
    }

    fun saveExperience(input: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt("exp", input)
        editor.commit()
    }

    fun saveCheckmarks(input: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt("checkmarks", input)
        editor.commit()
    }

    fun saveGold(input: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt("gold", input)
        editor.commit()
    }

    fun savePerks(input: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt("perks", input)
        editor.commit()
    }

    fun saveRetiredChars(input: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt("retiredChars", input)
        editor.commit()
    }

    fun getName() = sharedPreferences.getString("name", "")

    fun getClass() = sharedPreferences.getString("class", "")

    fun getLevel() = sharedPreferences.getInt("level", 1)

    fun getExperience() = sharedPreferences.getInt("exp", 0)

    fun getCheckmarks() = sharedPreferences.getInt("checkmarks", 0)

    fun getGold() = sharedPreferences.getInt("gold", 0)

    fun getPerks() = sharedPreferences.getInt("perks", 0)

    fun getRetiredChars() = sharedPreferences.getInt("retiredChars", 0)

}