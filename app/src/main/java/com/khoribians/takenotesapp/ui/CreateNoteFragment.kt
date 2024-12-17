package com.khoribians.takenotesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.khoribians.takenotesapp.R
import com.khoribians.takenotesapp.databinding.FragmentCreateNoteBinding
import com.khoribians.takenotesapp.db.data.Note
import com.khoribians.takenotesapp.util.DateUtil
import com.khoribians.takenotesapp.viewmodel.CreateNoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateNoteFragment : Fragment() {


    private val viewModel: CreateNoteViewModel by viewModels()
    private lateinit var binding: FragmentCreateNoteBinding

    private var color: Int = 0
    val noteData: CreateNoteFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.radioGroup.setOnCheckedChangeListener { radioGroup, i ->

            val radioButton: View = radioGroup.findViewById(i)
            val index = radioGroup.indexOfChild(radioButton)
            when (index) {
                0 -> color = requireContext().getColor(R.color.creamy)
                1 -> color = requireContext().getColor(R.color.red)
                2 -> color = requireContext().getColor(R.color.blue)
                3 -> color = requireContext().getColor(R.color.pink)
                4 -> color = requireContext().getColor(R.color.green)
                5 -> color = requireContext().getColor(R.color.cashmere)
                6 -> color = requireContext().getColor(R.color.moov)
            }
            binding.root.setBackgroundColor(color)
        }

        binding.radioGroup.check(binding.creamRd.id)

        if (noteData.note != null) {
            binding.titleEt.setText(noteData.note!!.title)
            binding.bodyEt.setText(noteData.note!!.thoughts)
            binding.radioGroup.check(getColorId(noteData.note!!.color))
        }

        binding.doneIv.setOnClickListener {
            if (noteData.note != null) {
                viewModel.update(
                    noteData.note!!.id, binding.titleEt.text.toString(), binding.bodyEt.text.toString(),
                    color, DateUtil.getTimeDate(DateUtil.TIME_DATE_FORMAT)
                )
            } else
                viewModel.insert(
                    binding.titleEt.text.toString(), binding.bodyEt.text.toString(),
                    color, DateUtil.getTimeDate(DateUtil.TIME_DATE_FORMAT)
                )
            findNavController().popBackStack()
        }


    }

    fun getColorId(color: Int): Int {
        var id = 0
        when (color) {
            requireContext().getColor(R.color.creamy) -> id = binding.creamRd.id
            requireContext().getColor(R.color.red) -> id = binding.redRd.id
            requireContext().getColor(R.color.blue) -> id = binding.blueRd.id
            requireContext().getColor(R.color.pink) -> id = binding.pinkRd.id
            requireContext().getColor(R.color.green) -> id = binding.greenRd.id
            requireContext().getColor(R.color.cashmere) -> id = binding.cashmereRd.id
            requireContext().getColor(R.color.moov) -> id = binding.moovRd.id
        }
        return id
    }


}