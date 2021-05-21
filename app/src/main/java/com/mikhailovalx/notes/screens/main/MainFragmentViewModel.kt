package com.mikhailovalx.notes.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mikhailovalx.notes.utilits.REPOSITORY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application){
    val  allNotes = REPOSITORY.allNotes
}