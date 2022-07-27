package com.ibrahim.notepad.ui.insertOrUpdate

import android.app.Application
import com.ibrahim.notepad.db.entity.NoteEntity
import com.ibrahim.notepad.core.base.BaseViewModel

class NoteDetailViewModel (application: Application) : BaseViewModel(application)  {
    var note:NoteEntity? = null
}