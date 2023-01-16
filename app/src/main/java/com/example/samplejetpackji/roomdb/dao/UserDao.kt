package com.example.samplejetpackji.roomdb.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.samplejetpackji.roomdb.entity.UserData

interface UserDao {

    @Query("select * from UserData")
   fun  getAlUserData():List<UserData>

   @Insert(onConflict = OnConflictStrategy.IGNORE)
   fun sendUserData(userData: UserData)
   @Delete()
   fun deleteUserData(userData: UserData)
}