package com.example.playertracker.viewModel

import androidx.lifecycle.ViewModel
import com.example.playertracker.model.Player

class PlayerStatViewModel: ViewModel() {

    fun changeCheckmark() {
        Player.gainCheckmarks()
    }

}