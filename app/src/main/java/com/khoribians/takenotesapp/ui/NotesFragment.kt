package com.khoribians.takenotesapp.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.khoribians.takenotesapp.R
import com.khoribians.takenotesapp.databinding.FragmentNotesBinding
import com.khoribians.takenotesapp.viewmodel.NotesViewModel

class NotesFragment : Fragment() {


    private val viewModel: NotesViewModel by viewModels()
    private lateinit var binding : FragmentNotesBinding

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

        binding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_createNoteFragment)
        }
    }
}