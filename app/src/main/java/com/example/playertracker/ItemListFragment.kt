package com.example.playertracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.playertracker.databinding.FragmentItemListBinding
import com.example.playertracker.viewModel.AddItemViewModel
import com.example.playertracker.viewModel.ItemListViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ItemListFragment : Fragment() {
    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!
    
    //private var layoutManager: RecyclerView.LayoutManager? = null
    //private var adapter: RecyclerView.Adapter<ItemCardAdapter.ItemCardViewHolder>? = null

    private val sharedViewModel: AddItemViewModel by activityViewModels()

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
            adapter = ItemCardAdapter(emptyList()/* realmFacade.getOwnedItems()    */)

        }
        //ustawic listenery i updaty UI

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
        var dialog = AddItemDialogFragment()
        dialog.show(childFragmentManager, "Custom Dialog")
    }


}