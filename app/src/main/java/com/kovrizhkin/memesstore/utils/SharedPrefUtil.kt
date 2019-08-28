package com.kovrizhkin.memesstore.utils

import android.content.SharedPreferences
import com.kovrizhkin.memesstore.App

object SharedPrefUtil {


    private const val PREF_NAME = "MEMES_PREF"

    fun putString(key: String, value: String) {
        val editor = getPrefs().edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String): String? {
        return getPrefs().getString(key, null)
    }

    fun removeField(key: String) {
        getPrefs().edit().remove(key).apply()
    }


    private fun getPrefs(): SharedPreferences =
        App.getContext()!!.getSharedPreferences(PREF_NAME, 0)
}