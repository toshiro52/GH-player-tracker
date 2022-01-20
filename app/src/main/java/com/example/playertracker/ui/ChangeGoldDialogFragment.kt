package com.example.playertracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.playertracker.R
import com.example.playertracker.model.Player
import com.example.playertracker.viewModel.PlayerStatViewModel
import com.google.android.material.textfield.TextInputEditText

class ChangeGoldDialogFragment: DialogFragment()  {

    private val sharedViewModel: PlayerStatViewModel by activityViewModels()
    private var valueChangeType: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceBundle: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.change_gold_dialog, container, false)

        setUpButtons(rootView)

        return rootView
    }

    private fun setUpButtons(rootView: View) {
        val textField: TextInputEditText = rootView.findViewById(R.id.itemReferenceNumberEditText)
        val addButton: Button = rootView.findViewById(R.id.confirmAddButton)
        val cancelButton: Button = rootView.findViewById(R.id.cancelAddButton)
        val changeTypeButton: Button = rootView.findViewById(R.id.setValueChange)

        addButton.setOnClickListener {
            val input = textField.text?.toString()
            if(!input.isNullOrEmpty())
                sharedViewModel.updateGold(input.toInt() * valueModifier())
            //TODO: else Toast()
            dismiss()
        }

        cancelButton.setOnClickListener {
            dismiss()
        }

        changeTypeButton.setOnClickListener {
            if(changeTypeButton.text == "+")
                changeTypeButton.text = "-"
            else
                changeTypeButton.text = "+"
            valueChangeType = !valueChangeType

        }
    }

    private fun valueModifier(): Int = if(valueChangeType) 1 else -1

}