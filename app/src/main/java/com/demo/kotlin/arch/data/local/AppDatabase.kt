package com.demo.kotlin.arch.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.demo.kotlin.arch.data.entities.Character

@Database(entities = arrayOf(Character::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            return instance ?: synchronized(this) {
                val instanceNew = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "word_database"
                )
                    .fallbackToDestructiveMigration()
                    .build().also {
                        instance = it
                    }

                // return instance
                instanceNew
            }
        }
    }


}