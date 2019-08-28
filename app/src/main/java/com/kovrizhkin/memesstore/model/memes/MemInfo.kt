package com.kovrizhkin.memesstore.model.memes


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MemInfo(
    @SerializedName("createdDate")
    val createdDate: Int,

    @SerializedName("description")
    val description: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("isFavorite")
    val isFavorite: Boolean,

    @SerializedName("photoUtl")
    val photoUtl: String,

    @SerializedName("title")
    val title: String
) : Serializable