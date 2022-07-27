package com.ibrahim.notepad.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahim.notepad.adapter.NoteAdapter
import com.ibrahim.notepad.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

        private var _binding: FragmentHomeBinding? = null
        private val binding get() = _binding!!

        private lateinit var noteAdapter: NoteAdapter
        private val viewModel: HomeViewModel by viewModels()

    //private val args:MovieDetailFragmentArgs by navArgs ()

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {

            _binding = FragmentHomeBinding.inflate(inflater, container, false)
            val view = binding.root

            initAdapter()
            observeNoteList()

            binding.btnPlus.setOnClickListener {
                val action= HomeFragmentDirections.actionHomeFragmentToNoteDetailFragment(null)
                Navigation.findNavController(it).navigate(action)
            }



            return view
        }


        //Fragment Destroy edildiğinde binding boşaltılsın diye
        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    private fun initAdapter() {
        noteAdapter = NoteAdapter ()
        binding.recyclerview.adapter = noteAdapter

        binding.recyclerview.layoutManager = GridLayoutManager(context, 3,LinearLayoutManager.VERTICAL,false)
    }


    private fun observeNoteList() {
        viewModel.noteList.observe(viewLifecycleOwner) { noteList ->
            noteAdapter.setList(noteList)
        }
    }
    }