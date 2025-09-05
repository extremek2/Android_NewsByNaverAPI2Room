package com.example.mynavernewsapiapplication2room.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [NaverNews::class],
    version = 1
)
abstract class NaverNewsDatabase: RoomDatabase() {
    abstract fun naverNewsDao() : NaverNewsDao

    companion object {
        @Volatile private var INSTANCE: NaverNewsDatabase? = null

        fun getInstance(context: Context): NaverNewsDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    NaverNewsDatabase::class.java,
                    "navernews_db"
                ).build().also { INSTANCE = it }
            }
    }
}

