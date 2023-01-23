package com.example.samplejetpackji.roomdb.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.samplejetpackji.roomdb.dao.UserDao
import com.example.samplejetpackji.roomdb.entity.UserData
import kotlinx.coroutines.CoroutineScope


@Database(entities = [UserData::class], version = 2, exportSchema = false)
abstract class UserRoomDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao


    companion object {



        @Volatile
        private var INSTANCE: UserRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): UserRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserRoomDatabase::class.java,
                    "UserDatabase"

                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance

                // return instance
                instance
            }
        }
    }

}