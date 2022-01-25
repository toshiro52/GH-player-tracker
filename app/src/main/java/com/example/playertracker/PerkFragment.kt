package com.example.playertracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.playertracker.databinding.FragmentPerkBinding

class PerkFragment : Fragment() {

    private var _binding: FragmentPerkBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPerkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            //adapter =
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}