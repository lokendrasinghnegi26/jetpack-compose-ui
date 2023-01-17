package com.example.samplejetpackji.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.samplejetpackji.TextField
import com.example.samplejetpackji.TextInput
import com.example.samplejetpackji.listItem
import com.example.samplejetpackji.roomdb.entity.UserData
import com.example.samplejetpackji.viewModel.UserViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch

@Composable
fun ShowData(navHostController: NavHostController, userViewModel: UserViewModel) {
    var allUsers = userViewModel.res.value

    val scope = rememberCoroutineScope()
    LazyColumn {
        items(allUsers) { res ->
            //  Text(text = res.userName)
            listItem(userData = res) {
                userViewModel.deleteData(res)
            }
        }
    }
}


