package com.example.playertracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.playertracker.databinding.FragmentPlayerStatBinding
import com.example.playertracker.ui.ChangeExperienceDialogFragment
import com.example.playertracker.ui.ChangeGoldDialogFragment
import com.example.playertracker.viewModel.PlayerStatViewModel

class PlayerStatFragment : Fragment() {
    private var _binding: FragmentPlayerStatBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PlayerStatViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayerStatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpButtons()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpButtons() {
        binding.changeExperience.setOnClickListener {
            changeExperience()
        }
        binding.changeGoldButton.setOnClickListener {
            changeGold()
        }
        binding.changeCheckmarksButton.setOnClickListener {
            changeCheckMarks()
        }
        binding.newCharacterButton.setOnClickListener {
            createNewCharacter()
        }
    }

    private fun changeExperience() {
        val dialog = ChangeExperienceDialogFragment()
        dialog.show(childFragmentManager, "Experience Gold Dialog")
    }

    private fun changeGold() {
        val dialog = ChangeGoldDialogFragment()
        dialog.show(childFragmentManager, "Change Gold Dialog")
    }

    private fun changeCheckMarks() {

    }

    private fun createNewCharacter() {
        val dialog = CreateCharacterFragment()
        dialog.show(childFragmentManager, "Create Character")
    }
}