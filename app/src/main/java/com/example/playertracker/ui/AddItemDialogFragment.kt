package com.example.playertracker

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.playertracker.viewModel.AddItemViewModel
import com.google.android.material.textfield.TextInputEditText

class AddItemDialogFragment: DialogFragment() {

    private val sharedViewModel: AddItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceBundle: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.add_item_dialog, container, false)

        setUpButtons(rootView)

        return rootView
    }

    private fun setUpButtons(rootView: View) {
        val textField: TextInputEditText = rootView.findViewById(R.id.itemReferenceNumberEditText)
        val addButton: Button = rootView.findViewById(R.id.confirmAddButton)
        val cancelButton: Button = rootView.findViewById(R.id.cancelAddButton)

        addButton.setOnClickListener {
            val input = textField.text.toString()
            if(sharedViewModel.validateInput(input)) {
                sharedViewModel.addItem(input.toInt())
            }
            dismiss()
        }

        cancelButton.setOnClickListener {
            dismiss()
        }
    }

}