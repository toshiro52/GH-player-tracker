package com.example.playertracker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddItemViewModel : ViewModel() {
    private val _itemReferenceNumber = MutableLiveData<Int>(0)
    val itemReferenceNumber: LiveData<Int> = _itemReferenceNumber


    fun setItemReferenceNumber(itemRefNum: Int) {
        _itemReferenceNumber.value = itemRefNum
    }

    fun checkItemRefNum(itemRefNum: Int): Boolean {
        return itemRefNum in (1..150)
    }
}