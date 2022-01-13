package com.example.playertracker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddItemViewModel : ViewModel() {

    fun addItem(itemRefNum: Int) {
        //RealmFacade.addItem(ItemRefNumber)
    }

    fun validateInput(input: String): Boolean = !input.isNullOrEmpty() && checkItemRefNum(input.toInt())

    private fun checkItemRefNum(itemRefNum: Int): Boolean {
        return itemRefNum in (1..150)
    }

}