package com.mikhailovalx.notes.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mikhailovalx.notes.database.firebase.AppFirebaseRepository
import com.mikhailovalx.notes.database.room.AppRoomDatabase
import com.mikhailovalx.notes.database.room.AppRoomRepository
import com.mikhailovalx.notes.utilits.REPOSITORY
import com.mikhailovalx.notes.utilits.TYPE_FIREBASE
import com.mikhailovalx.notes.utilits.TYPE_ROOM
import com.mikhailovalx.notes.utilits.showToast

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }

            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase({ onSuccess() }, { showToast(it) })
            }
        }
    }
}