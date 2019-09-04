package com.kovrizhkin.memesstore.model.memes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memes_table")
data class MemInfoEntity(

    @ColumnInfo(name = "created_date") override val createdDate: Long,

    @ColumnInfo(name = "description") override val description: String,

    @PrimaryKey @ColumnInfo(name = "id") override val id: String,

    @ColumnInfo(name = "is_favorite") override val isFavorite: Boolean,

    @ColumnInfo(name = "photo_utl") override val photoUtl: String,

    @ColumnInfo(name = "title") override val title: String
) : MemInterface