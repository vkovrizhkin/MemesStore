package com.kovrizhkin.memesstore.repository.storage

import com.google.gson.Gson
import com.kovrizhkin.memesstore.model.auth.AuthResponse
import com.kovrizhkin.memesstore.model.auth.UserInfo
import com.kovrizhkin.memesstore.utils.SharedPrefUtil

object UserStorage {


    private const val ACCESS_TOKEN = "ACCESS_TOKEN"
    private const val PROFILE_INFO = "PROFILE_INFO"

    fun cleanToken() {
        SharedPrefUtil.removeField(ACCESS_TOKEN)
    }

    fun cleanProfileInfo() {
        SharedPrefUtil.removeField(PROFILE_INFO)
    }


    fun saveSession(loginResponse: AuthResponse) {
        saveProfileInfo(loginResponse.userInfo)
        saveToken(loginResponse.accessToken)
    }

    private fun saveToken(token: String) {
        SharedPrefUtil.putString(ACCESS_TOKEN, token)
    }

    fun getToken(): String? {

        return SharedPrefUtil.getString(ACCESS_TOKEN)
    }

    private fun saveProfileInfo(profile: UserInfo) {

        val json = Gson().toJson(profile)
        SharedPrefUtil.putString(PROFILE_INFO, json)
    }

    fun getProfileInfo(): UserInfo? {
        val json = SharedPrefUtil.getString(PROFILE_INFO)
        return Gson().fromJson(json, UserInfo::class.java)
    }

}