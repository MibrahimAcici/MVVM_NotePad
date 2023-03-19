package com.ibrahim.mvvm_notepad.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ibrahim.mvvm_notepad.db.dao.NoteDao
import com.ibrahim.mvvm_notepad.db.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun notedao():NoteDao
}