package com.ibrahim.notepad.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ibrahim.notepad.db.entity.NoteEntity

@Dao
interface NoteDao {
    @Query("SELECT*FROM note_table" )
    fun getAllNotes():LiveData<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg note:NoteEntity?)

    @Query("DELETE FROM note_table WHERE noteId= :noteId")
    fun DeleteById(vararg noteId:Int):Int

}