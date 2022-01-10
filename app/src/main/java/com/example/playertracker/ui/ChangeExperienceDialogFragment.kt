package com.example.playertracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.playertracker.R
import com.example.playertracker.model.Player
import com.google.android.material.textfield.TextInputEditText

class ChangeExperienceDialogFragment: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceBundle: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.change_experience_dialog, container, false)

        setUpButtons(rootView)

        return rootView
    }

    private fun setUpButtons(rootView: View) {
        val textField: TextInputEditText = rootView.findViewById(R.id.experienceValueEditText)
        val addButton: Button = rootView.findViewById(R.id.confirmButton)
        val cancelButton: Button = rootView.findViewById(R.id.cancelButton)

        addButton.setOnClickListener {
            val input = textField.text?.toString()
            if(!input.isNullOrEmpty())
                Player.changeExperience(input.toInt())
            //TODO: else Toast()
            dismiss()
        }

        cancelButton.setOnClickListener {
            dismiss()
        }
    }
}