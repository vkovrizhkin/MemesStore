package com.kovrizhkin.memesstore.repository.storage

import androidx.annotation.WorkerThread
import com.kovrizhkin.memesstore.model.memes.MemInfo
import com.kovrizhkin.memesstore.model.memes.MemInfoEntity
import com.kovrizhkin.memesstore.model.room.dao.MemDao
import io.reactivex.Maybe

class MemStorage(private val memDao: MemDao) {

    val allMemes: Maybe<List<MemInfoEntity>> = memDao.getAllMemes()

    @WorkerThread
    suspend fun insertMem(mem: MemInfoEntity) {
        memDao.insertMem(mem)
    }

}