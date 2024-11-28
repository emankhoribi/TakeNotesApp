package com.khoribians.takenotesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.khoribians.takenotesapp.R
import com.khoribians.takenotesapp.databinding.FragmentCreateNoteBinding
import com.khoribians.takenotesapp.viewmodel.CreateNoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateNoteFragment : Fragment() {


    private val viewModel: CreateNoteViewModel by viewModels()
    private lateinit var binding: FragmentCreateNoteBinding

    private  var color: Int = 0

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
            when(index){
                0 -> color = requireContext().getColor(R.color.creamy)
                1 -> color = requireContext().getColor(R.color.red)
                2 -> color = requireContext().getColor(R.color.blue)
                3 -> color = requireContext().getColor(R.color.pink)
                4 -> color = requireContext().getColor(R.color.green)
                5 -> color = requireContext().getColor(R.color.cashmere)
                6 -> color = requireContext().getColor(R.color.moov)
                7 -> color = requireContext().getColor(R.color.black)
            }
            binding.root.setBackgroundColor(color)
        }

        binding.radioGroup.check(binding.creamRd.id)
    }
}