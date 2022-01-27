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

    private val _deckState = MutableLiveData(AttackDeck.deckState.needsShuffle)
    val deckState: LiveData<Boolean>
        get() = _deckState

    val iterator = AttackDeck.createIterator()

    fun drawCard() {
        if(iterator.hasNext()) {
            val currentCard = iterator.next()
            updateURL(currentCard.cardImageUrl)
            if(currentCard.attackValue == "2x" || currentCard.attackValue == "MISS"){
                AttackDeck.changeDeckState(true)
                _deckState.value = AttackDeck.deckState.needsShuffle
            }
        }
        else {
            AttackDeck.changeDeckState(true)
            _deckState.value = AttackDeck.deckState.needsShuffle
        }
    }

    fun shuffleDeck() {
        _imageUrl.value = ""
        iterator.reset()
        AttackDeck.shuffleDeck()
        AttackDeck.changeDeckState(false)
        _deckState.value = AttackDeck.deckState.needsShuffle
    }

    fun getDeckStateMessage() = AttackDeck.deckState.displayMessage()


    private fun updateURL(cardImage: String) {
        _imageUrl.value = cardImage
    }
}