package com.ibrahim.mvvm_notepad.ui.insertOrUpdate

import android.app.Application
import com.ibrahim.mvvm_notepad.db.entity.NoteEntity
import com.ibrahim.mvvm_notepad.core.base.BaseViewModel

class NoteDetailViewModel (application: Application) : BaseViewModel(application)  {
    var note:NoteEntity? = null
}