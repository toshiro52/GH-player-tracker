package com.example.playertracker.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.playertracker.databinding.FragmentActionCardBinding
import com.example.playertracker.realm.RealmDatabaseFacade
import com.example.playertracker.viewModel.ActionCardViewModel

class ActionCardFragment : Fragment() {

    private var _binding: FragmentActionCardBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    private val viewModel: ActionCardViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActionCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = AbilityCardAdapter(RealmDatabaseFacade.getAvailableAbilitiCards())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}