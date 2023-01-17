package com.example.samplejetpackji.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.samplejetpackji.repository.UserRepository
import com.example.samplejetpackji.roomdb.entity.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository):ViewModel() {
    fun insertData(userData: UserData) = viewModelScope.launch { repository.insertUserData(userData) }
    fun deleteData(userData: UserData) = viewModelScope.launch { repository.deleteUserData(userData) }
     val allUsers:Flow<List<UserData>>  = repository.getUsers
    fun updateData(userData: UserData)= viewModelScope.launch { repository.updateUserData(userData) }
    private val _res:MutableState<List<UserData>> = mutableStateOf(listOf())
    val res:State<List<UserData>> = _res


    class UserViewModelFactory(private val userRepository: UserRepository):
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return UserViewModel(userRepository) as T
            }
            throw IllegalArgumentException("Unknown VieModel Class")    }
    }
    init {
        getAllData()
    }

   private fun getAllData() = viewModelScope.launch{
        try {
            repository.getUsers.collect{
                _res.value = it
            }
        }catch (e:Exception){
            Log.d("main", "exception: ${e.message} ")
        }
    }

}