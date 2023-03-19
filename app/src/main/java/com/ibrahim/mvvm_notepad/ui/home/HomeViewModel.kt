package com.ibrahim.mvvm_notepad.ui.home

import android.app.Application
import com.ibrahim.mvvm_notepad.db.Database
import com.ibrahim.mvvm_notepad.core.base.BaseViewModel

class HomeViewModel(application: Application) : BaseViewModel(application) {

    val noteList = Database.getDatabase(getApplication()).notedao().getAllNotes()

}
