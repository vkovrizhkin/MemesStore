package com.kovrizhkin.memesstore.model.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kovrizhkin.memesstore.model.memes.MemInfoEntity

@Database(entities = [MemInfoEntity::class], version = 1)
abstract class MemesDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: MemesDatabase? = null

        fun getDatabase(context: Context): MemesDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MemesDatabase::class.java,
                    "Memes_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}