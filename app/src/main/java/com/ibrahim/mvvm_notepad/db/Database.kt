package com.ibrahim.mvvm_notepad.db

import android.content.Context
import androidx.room.Room

object  Database {

    private var appDatabase:AppDatabase? = null

    fun getDatabase(applicationContext:Context): AppDatabase {
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java,"notes")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
        return appDatabase!!
    }



}