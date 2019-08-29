package com.kovrizhkin.memesstore.model.memes


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MemInfo(
    @SerializedName("createdDate")
    override val createdDate: Long,

    @SerializedName("description")
    override val description: String,

    @SerializedName("id")
    override val id: String,

    @SerializedName("isFavorite")
    override val isFavorite: Boolean,

    @SerializedName("photoUtl")
    override val photoUtl: String,

    @SerializedName("title")
    override val title: String
) : Serializable, MemInterface