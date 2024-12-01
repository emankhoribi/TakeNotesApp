package com.khoribians.takenotesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.khoribians.takenotesapp.R
import com.khoribians.takenotesapp.databinding.FragmentNotesBinding
import com.khoribians.takenotesapp.ui.adapter.NotesAdapter
import com.khoribians.takenotesapp.viewmodel.NotesViewModel
import kotlinx.coroutines.launch


class NotesFragment : Fragment() {


    private val viewModel: NotesViewModel by viewModels()
    private lateinit var binding: FragmentNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.notesRv.layoutManager = GridLayoutManager(requireContext(), 2)

        val notesAdapter = NotesAdapter()
        lifecycleScope.launch {
            viewModel.notesFLow.collect {
                notesAdapter.submitList(it)
                binding.notesRv.adapter = notesAdapter
            }
        }
        binding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_createNoteFragment)
        }
    }
}