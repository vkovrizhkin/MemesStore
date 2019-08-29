package com.kovrizhkin.memesstore.model.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kovrizhkin.memesstore.model.memes.MemInfoEntity
import io.reactivex.Maybe

@Dao
interface MemDao {
    @Query("")
    fun getAllMemes(): Maybe<List<MemInfoEntity>>

    @Insert
    fun insertMem(mem: MemInfoEntity)
}