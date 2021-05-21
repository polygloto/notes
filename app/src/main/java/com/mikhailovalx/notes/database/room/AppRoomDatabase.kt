package com.mikhailovalx.notes.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mikhailovalx.notes.models.AppNote

@Database(entities = [AppNote::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun getAppRoomDao(): AppRoomDao

    companion object{

        @Volatile // This annotation disables database caching.
        private var database: AppRoomDatabase? = null

        @Synchronized // This annotation prevents multiple instances from accessing the function at the same time.
        fun getInstance(context: Context): AppRoomDatabase{
            return if (database == null){
                database = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    "database"
                ).build()
                database as AppRoomDatabase
            }else database as AppRoomDatabase
        }
    }
}