package com.example.playertracker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.playertracker.model.AttackDeck
import com.example.playertracker.realm.AttackCard

class AttackDeckViewModel : ViewModel() {

    private val _imageUrl = MutableLiveData("")
    val imageUrl: LiveData<String>
        get() = _imageUrl

    val iterator = AttackDeck.createIterator()

    fun drawCard() {
        if(iterator.hasNext()) {
            val currentCard = iterator.next()
            updateURL(currentCard.cardImageUrl)
        }
    }

    fun shuffleDeck() {
        _imageUrl.value = ""
        iterator.reset()
        AttackDeck.shuffleDeck()
    }


    private fun updateURL(cardImage: String) {
        _imageUrl.value = cardImage
    }
}