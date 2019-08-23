package com.kovrizhkin.memesstore.model.auth


import com.google.gson.annotations.SerializedName

data class UserInfo(

    @SerializedName("firstName")
    val firstName: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("lastName")
    val lastName: String,

    @SerializedName("userDescription")
    val userDescription: String,

    @SerializedName("username")
    val username: String
)