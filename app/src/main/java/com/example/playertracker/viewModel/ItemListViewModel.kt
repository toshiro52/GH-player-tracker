package com.example.playertracker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.playertracker.realm.Item
import com.example.playertracker.realm.RealmDatabaseFacade

class ItemListViewModel : ViewModel() {

    fun removeItem(itemReferenceNumber: Int) {

    }

    fun addItem(itemReferenceNumber: Int) {
        RealmDatabaseFacade.changeOwnedStatus(itemReferenceNumber, false)
    }

    fun validateInput(input: String): Boolean = !input.isNullOrEmpty() && checkItemRefNum(input.toInt())

    private fun checkItemRefNum(itemRefNum: Int): Boolean {
        return itemRefNum in (1..150)
    }

}