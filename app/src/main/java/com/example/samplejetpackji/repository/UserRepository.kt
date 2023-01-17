package com.example.samplejetpackji.repository

import com.example.samplejetpackji.roomdb.dao.UserDao
import com.example.samplejetpackji.roomdb.entity.UserData
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {
    suspend fun insertUserData(userData: UserData){
        userDao.sendUserData(userData)
    }
    suspend fun deleteUserData(userData: UserData){
        userDao.deleteUserData(userData)
    }

   var getUsers:Flow<List<UserData>> = userDao.getAlUserData()


 }