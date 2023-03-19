package com.ibrahim.mvvm_notepad.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.mvvm_notepad.databinding.NoteItemBinding
import com.ibrahim.mvvm_notepad.db.entity.NoteEntity
import com.ibrahim.mvvm_notepad.ui.home.HomeFragmentDirections

class NoteAdapter(): RecyclerView.Adapter<NoteAdapter.NoteVH>() {

    private  val notes:ArrayList<NoteEntity> = arrayListOf()

    fun setList(notes:List<NoteEntity>){
        this.notes.clear()
        this.notes.addAll(notes)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.NoteVH {
        return NoteVH(NoteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NoteAdapter.NoteVH, position: Int) {
        val note= notes[position]

        holder.binding.rcTxtTitle.text=note.title
        holder.binding.rcTxtNote.text=note.noteDetail

        //val noteArray= arrayOf(note.title,note.noteDetail)
        holder.binding.root.setOnClickListener {

        val action= HomeFragmentDirections.actionHomeFragmentToNoteDetailFragment(note)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int =notes.size

    inner class NoteVH(val binding: NoteItemBinding): RecyclerView.ViewHolder(binding.root) {
    }
}