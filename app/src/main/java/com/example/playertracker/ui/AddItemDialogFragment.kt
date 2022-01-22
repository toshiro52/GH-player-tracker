package com.example.playertracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.playertracker.R
import com.example.playertracker.viewModel.ItemListViewModel
import com.google.android.material.textfield.TextInputEditText

class AddItemDialogFragment: DialogFragment() {

    private val viewModel: ItemListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceBundle: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.add_item_dialog, container, false)

        setUpButtons(rootView)

        return rootView
    }

    private fun setUpButtons(rootView: View) {
        val textField: TextInputEditText = rootView.findViewById(R.id.itemReferenceNumberEditText)
        val addButton: Button = rootView.findViewById(R.id.confirmAddButton)
        val cancelButton: Button = rootView.findViewById(R.id.cancelAddButton)

        addButton.setOnClickListener {
            val input = textField.text.toString()
            if(viewModel.validateInput(input)) {
                viewModel.addItem(input.toInt())
            }
            dismiss()
        }

        cancelButton.setOnClickListener {
            dismiss()
        }
    }

}