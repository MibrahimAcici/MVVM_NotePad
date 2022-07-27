package com.ibrahim.notepad.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "note_table")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var noteId:Int=0,

    @ColumnInfo(name = "title")
    var title:String="",

    @ColumnInfo(name="noteDetail")
    var noteDetail:String=""

):Parcelable
