package com.example.playertracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.playertracker.databinding.FragmentAttackDeckBinding
import com.example.playertracker.viewModel.AttackDeckViewModel
import com.squareup.picasso.Picasso

class AttackDeckFragment : Fragment() {
    private var _binding: FragmentAttackDeckBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AttackDeckViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAttackDeckBinding.inflate(inflater, container, false)

        viewModel.imageUrl.observe(viewLifecycleOwner, {
            newUrl -> Picasso.get().load("file:///android_asset/attackCard/$newUrl.png").into(binding.drawnCardImageView)
        })

        viewModel.deckState.observe(viewLifecycleOwner, {
            newState ->
            binding.deckStateTextView.text = viewModel.getDeckStateMessage()
        })

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
        binding.cardBackImageView.setOnClickListener {
            drawCard()
        }
        binding.refreshDeckImageView.setOnClickListener {
            shuffleDeck()
        }
    }

    private fun drawCard() {
        viewModel.drawCard()
    }

    private fun shuffleDeck() {
        viewModel.shuffleDeck()
    }

}