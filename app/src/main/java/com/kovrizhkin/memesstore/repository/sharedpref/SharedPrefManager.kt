package com.kovrizhkin.memesstore.repository.sharedpref

import android.content.SharedPreferences
import com.google.gson.Gson
import com.kovrizhkin.memesstore.App
import com.kovrizhkin.memesstore.model.auth.AuthResponse
import com.kovrizhkin.memesstore.model.auth.UserInfo

object SharedPrefManager {


    private const val PREF_NAME = "MEMES_PREF"
    private const val ACCESS_TOKEN = "ACCESS_TOKEN"
    private const val PROFILE_INFO = "PROFILE_INFO"

    fun cleanToken() {
        getPrefs().edit().remove(ACCESS_TOKEN).apply()
    }

    fun cleanProfileInfo() {
        getPrefs().edit().remove(PROFILE_INFO).apply()
    }


    fun saveSession(loginResponse: AuthResponse) {
        saveProfileInfo(loginResponse.userInfo)
        saveToken(loginResponse.accessToken)
    }

    private fun saveToken(token: String) {
        val editor = getPrefs().edit()
        editor.putString(ACCESS_TOKEN, token)
        editor.apply()
    }

    fun getToken(): String? {

        return getPrefs().getString(ACCESS_TOKEN, null)
    }

    private fun saveProfileInfo(profile: UserInfo) {
        val editor = getPrefs().edit()
        val json = Gson().toJson(profile)
        editor.putString(PROFILE_INFO, json)
        editor.apply()
    }

    fun getProfileInfo(): UserInfo? {
        val json = getPrefs().getString(PROFILE_INFO, "")
        return Gson().fromJson(json, UserInfo::class.java)
    }

    private fun getPrefs(): SharedPreferences =
        App.getContext()!!.getSharedPreferences(PREF_NAME, 0)

}