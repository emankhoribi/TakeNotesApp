package com.khoribians.takenotesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.khoribians.takenotesapp.R
import com.khoribians.takenotesapp.databinding.FragmentNotesBinding
import com.khoribians.takenotesapp.db.data.Note
import com.khoribians.takenotesapp.ui.adapter.NotesAdapter
import com.khoribians.takenotesapp.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotesFragment : Fragment(), NotesAdapter.RecyclerViewEvent {


    private val viewModel: NotesViewModel by viewModels()
    private lateinit var binding: FragmentNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        binding.notesRv.layoutManager = StaggeredGridLayoutManager( 2, StaggeredGridLayoutManager.VERTICAL)

        val notesAdapter = NotesAdapter(this)
        binding.notesRv.adapter = notesAdapter
        viewModel.getNotes()
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.notesFLow.collect {
                    notesAdapter.submitList(it)

                }
            }
        }

        binding.searchEt.doOnTextChanged { text, start, before, count ->
            viewModel.getSearchNotes("%$text%")
        }
        binding.addBtn.setOnClickListener {

            findNavController().navigate(R.id.action_notesFragment_to_createNoteFragment)
        }
    }

    override fun onItemClick(note: Note) {
        val directions = NotesFragmentDirections.actionNotesFragmentToCreateNoteFragment(note)
        findNavController().navigate(directions)
    }
}