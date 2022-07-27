package com.ibrahim.notepad.ui.home

import android.app.Application
import com.ibrahim.notepad.db.Database
import com.ibrahim.notepad.core.base.BaseViewModel

class HomeViewModel(application: Application) : BaseViewModel(application) {

    val noteList = Database.getDatabase(getApplication()).notedao().getAllNotes()

}
