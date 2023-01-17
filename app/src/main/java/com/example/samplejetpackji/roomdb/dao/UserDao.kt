package com.example.samplejetpackji.roomdb.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.samplejetpackji.roomdb.entity.UserData
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("select * from UserData")
    fun getAlUserData(): Flow<List<UserData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun sendUserData(userData: UserData)

    @Delete()
    suspend fun deleteUserData(userData: UserData)
    @Update
    suspend fun updateData(userData: UserData)
}