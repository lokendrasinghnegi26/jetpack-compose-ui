package com.example.samplejetpackji.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.samplejetpackji.repository.UserRepository
import com.example.samplejetpackji.roomdb.entity.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository):ViewModel() {
    fun insertData(userData: UserData) = viewModelScope.launch { repository.insertUserData(userData) }
    fun deleteData(userData: UserData) = viewModelScope.launch { repository.deleteUserData(userData) }
     val allUsers:Flow<List<UserData>>  = repository.getUsers


    class UserViewModelFactory(private val userRepository: UserRepository):
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return UserViewModel(userRepository) as T
            }
            throw IllegalArgumentException("Unknown VieModel Class")    }
    }

}