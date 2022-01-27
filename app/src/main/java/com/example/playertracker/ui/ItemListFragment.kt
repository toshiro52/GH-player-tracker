package com.example.playertracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.playertracker.ItemCardAdapter
import com.example.playertracker.databinding.FragmentItemListBinding
import com.example.playertracker.realm.RealmDatabaseFacade
import com.example.playertracker.viewModel.ItemListViewModel

class ItemListFragment : Fragment() {
    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ItemListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ItemCardAdapter(RealmDatabaseFacade.getOwnedItems())
        }

        setupButtons()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupButtons() {
        binding.addItemFAB.setOnClickListener {
            showAddItemDialog()
        }

    }

    private fun showAddItemDialog() {
        val dialog = AddItemDialogFragment()
        dialog.show(childFragmentManager, "Add Item Dialog")
    }

}