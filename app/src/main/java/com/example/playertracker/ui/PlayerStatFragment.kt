package com.example.playertracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.playertracker.databinding.FragmentPlayerStatBinding
import com.example.playertracker.ui.ChangeExperienceDialogFragment
import com.example.playertracker.ui.ChangeGoldDialogFragment
import com.example.playertracker.ui.CreateCharacterFragment
import com.example.playertracker.viewModel.PlayerStatViewModel

class PlayerStatFragment : Fragment() {
    private var _binding: FragmentPlayerStatBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PlayerStatViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayerStatBinding.inflate(inflater, container, false)

        viewModel.name.observe(viewLifecycleOwner, {
            newName -> binding.charNameTextField.setText(newName)
        })

        viewModel.characterClass.observe(viewLifecycleOwner, {
            newClass -> binding.classNameTextField.setText(newClass)
        })

        viewModel.level.observe(viewLifecycleOwner, {
            newLevel -> binding.levelTextField.setText(newLevel.toString())
        })

        viewModel.experience.observe(viewLifecycleOwner, {
            newExp -> binding.experience.setText(newExp.toString())
        })

        viewModel.gold.observe(viewLifecycleOwner, {
            newGold -> binding.goldCountTextField.setText(newGold.toString())
        })

        viewModel.checkmarks.observe(viewLifecycleOwner, {
            newCheckmarks -> binding.checkmarksTextField.setText(newCheckmarks.toString())
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpText()
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
        binding.addCheckmarksButton.setOnClickListener {
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
        viewModel.changeCheckmark()
    }

    private fun createNewCharacter() {
        val dialog = CreateCharacterFragment()
        dialog.show(childFragmentManager, "Create Character")

    }

    private fun setUpText() {
        binding.charNameTextField.setText(viewModel.getName())
        binding.classNameTextField.setText(viewModel.getClass())
        binding.levelTextField.setText(viewModel.getLevel().toString())
        binding.experience.setText(viewModel.getExperience().toString())
        binding.goldCountTextField.setText(viewModel.getGold().toString())
        binding.checkmarksTextField.setText(viewModel.getCheckmarks().toString())
    }
}