package com.kovrizhkin.memesstore.model.auth


import com.google.gson.annotations.SerializedName

data class AuthResponse(

    @SerializedName("accessToken")
    val accessToken: String,

    @SerializedName("userInfo")
    val userInfo: UserInfo
)