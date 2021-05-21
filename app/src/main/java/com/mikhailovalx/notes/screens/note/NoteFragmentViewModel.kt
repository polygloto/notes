package com.mikhailovalx.notes.screens.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mikhailovalx.notes.models.AppNote
import com.mikhailovalx.notes.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteFragmentViewModel(application: Application) : AndroidViewModel(application) {
    fun delete(note: AppNote, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.delete(note){
                onSuccess()
            }
        }
}