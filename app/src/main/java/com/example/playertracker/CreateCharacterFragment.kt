package com.example.playertracker

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.playertracker.databinding.FragmentCreateCharacterBinding
import com.example.playertracker.viewModel.CreateCharacterViewModel
import com.example.playertracker.viewModel.PlayerStatViewModel


class CreateCharacterFragment : DialogFragment() {

    private var _binding: FragmentCreateCharacterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PlayerStatViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpButtons()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(
            STYLE_NORMAL,
            android.R.style.Theme_Black_NoTitleBar_Fullscreen
        )
    }

    override fun onResume() {
        super.onResume()
        val charClasses = resources.getStringArray(R.array.character_classes)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, charClasses)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

    }

    private fun setUpButtons() {
        //binding.toolbar.inflateMenu(R.menu.top_app_bar)
        binding.toolbar.setNavigationOnClickListener{
            dismiss()
        }
        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.action_save -> {
                    if(viewModel.validateLevelInput(binding.startingLevel.text.toString())
                                && viewModel.validateNameInput(binding.nameInputEditText.text.toString())){

                        val selectedClass = binding.autoCompleteTextView.text.toString()
                        Log.d("TAG", "selected $selectedClass")
                        viewModel.saveCharacter(binding.nameInputEditText.text.toString(), selectedClass ,binding.startingLevel.text.toString().toInt())
                        dismiss()
                        Toast.makeText(context, "Successfully Created Character", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(context, "Invalid Level", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
                else -> false
            }

        }
    }

}