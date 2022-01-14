package com.example.playertracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.playertracker.databinding.FragmentAttackDeckBinding

class AttackDeckFragment : Fragment() {

    private var _binding: FragmentAttackDeckBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAttackDeckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpButtons()
        setUpText()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpButtons() {
        binding.cardBackImageView.setOnClickListener {
            drawCard()
        }
        binding.refreshDeckImageView.setOnClickListener {
            shuffleDeck()
        }
    }

    private fun setUpText() {

    }

    private fun drawCard() {

    }

    private fun shuffleDeck() {
    }

}