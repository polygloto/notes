package com.mikhailovalx.notes.utilits

import android.content.Context
import android.content.SharedPreferences

object AppPreference {

    private const val INIT_USER = "initUser"
    private const val TYPE_DB = "typeDB"
    private const val NAME_PREF = "preference"

    private lateinit var mPreference: SharedPreferences

    fun getPreference(context: Context) : SharedPreferences{
        mPreference = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
        return mPreference
    }

    fun setInitUser(init: Boolean){
        mPreference.edit()
            .putBoolean(INIT_USER, init)
            .apply()
    }

    fun setTypeDb(type: String){
        mPreference.edit()
            .putString(TYPE_DB, type)
            .apply()
    }

    fun getInitUser(): Boolean{
        return  mPreference.getBoolean(INIT_USER, false)
    }

    fun getTypeDb(): String{
        return mPreference.getString(TYPE_DB, TYPE_ROOM).toString()
    }
}