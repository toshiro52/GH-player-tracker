package com.example.playertracker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddItemViewModel : ViewModel() {

    fun validateInput(input: String): Boolean = checkItemRefNum(input.toInt()) && !input.isNullOrEmpty()

    fun addItem(itemRefNum: Int) {
        //RealmFacade.addItem(ItemRefNumber)
    }

    private fun checkItemRefNum(itemRefNum: Int): Boolean {
        return itemRefNum in (1..150)
    }

}