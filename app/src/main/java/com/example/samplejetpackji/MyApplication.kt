package com.example.samplejetpackji

import android.app.Application
import com.example.samplejetpackji.repository.UserRepository
import com.example.samplejetpackji.roomdb.database.UserRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyApplication:Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { UserRoomDatabase.getDatabase(this,applicationScope) }
    val repository by lazy { UserRepository(database.UserDao())}
}