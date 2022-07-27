package com.ibrahim.notepad.ui.insertOrUpdate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ibrahim.notepad.R
import com.ibrahim.notepad.databinding.DeleteDialogBinding
import com.ibrahim.notepad.databinding.FragmentNoteDetailBinding
import com.ibrahim.notepad.db.Database
import com.ibrahim.notepad.db.entity.NoteEntity


class NoteDetailFragment : Fragment() {

    private var _binding: FragmentNoteDetailBinding? = null
    private val binding get() = _binding!!

    lateinit var deleteDialogBinding: DeleteDialogBinding
    lateinit var bottomSheet: BottomSheetDialog

    private val args: NoteDetailFragmentArgs by navArgs()
    private val viewModel: NoteDetailViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        deleteDialogBinding = DeleteDialogBinding.inflate(inflater, container, false)
        bottomSheet = BottomSheetDialog(requireContext(), R.style.BottomSheetStyle)
        bottomSheet.setContentView(deleteDialogBinding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListeners()
        initNote()
    }

    private fun initNote() {
        viewModel.note = args.currentNote ?: NoteEntity()

        if (args.currentNote == null) {
            prepareInsertProcess()
        } else {
            prepareUpdateProcess()
        }
    }

    private fun prepareUpdateProcess() {
        binding.titlePage.text = "Update Note"
        binding.titlePage.setTextColor(binding.titlePage.context.getColor(R.color.red))
        binding.noteDetailTitle.setText(viewModel.note?.title)
        binding.noteDetailNote.setText(viewModel.note?.noteDetail)
        binding.delete.visibility = View.VISIBLE
    }

    private fun prepareInsertProcess() {
        binding.titlePage.text = "Insert Note"

    }

    private fun initClickListeners() {
        binding.noteDetailBtnSave.setOnClickListener {
            onSaveClick()
        }
        binding.delete.setOnClickListener {
            onDeleteClick()
        }

        deleteDialogBinding.deleteDialogYes.setOnClickListener {
            Database.getDatabase(applicationContext = requireContext()).notedao()
                .DeleteById(viewModel.note!!.noteId)
            bottomSheet.dismiss()
            findNavController().navigateUp()
        }

        deleteDialogBinding.deleteDialogNo.setOnClickListener {
            bottomSheet.dismiss()
        }
    }

    private fun onDeleteClick() {

        bottomSheet.show()
    }

    private fun onSaveClick() {
        viewModel.note.apply {
            this?.title = binding.noteDetailTitle.text.toString()
            this?.noteDetail = binding.noteDetailNote.text.toString()
        }
        Database.getDatabase(applicationContext = requireContext()).notedao()
            .insertAll(viewModel.note)
        findNavController().navigateUp()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}