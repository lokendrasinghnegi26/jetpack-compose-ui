package com.example.samplejetpackji.roomdb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserData")
data class UserData (@PrimaryKey @ColumnInfo(name = "UserName") val userName:String, @ColumnInfo(name = "Password")val password:String){
}