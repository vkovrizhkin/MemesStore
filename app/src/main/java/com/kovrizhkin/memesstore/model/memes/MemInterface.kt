package com.kovrizhkin.memesstore.model.memes

interface MemInterface {

    val createdDate: Long

    val description: String

    val id: String

    val isFavorite: Boolean

    val photoUtl: String

    val title: String
}