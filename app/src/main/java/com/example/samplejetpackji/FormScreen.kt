package com.example.samplejetpackji

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.samplejetpackji.navigation.Screen
import com.example.samplejetpackji.roomdb.entity.UserData
import com.example.samplejetpackji.viewModel.UserViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun FormScreen(navHostController: NavHostController, userViewModel: UserViewModel) {
    val context = LocalContext.current
    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            TextInput(text = username, onChange = {
                username = it
            }, label = "enter username")
            Spacer(modifier = Modifier.height(10.dp))
            TextInput(text = password, onChange = {
                password = it
            }, label = "enter password")
            Spacer(modifier = Modifier.height(10.dp))
            ButtonField(text = "submit") {
                userViewModel.insertData(UserData( username,password))
                Toast.makeText(context,"loginpage",Toast.LENGTH_SHORT).show()
            }
            Spacer(modifier = Modifier.height(10.dp))

            ButtonField(text = "update") {
                scope.launch {
                    userViewModel.allUsers.collect{
                        userViewModel.updateData(UserData(username,password).apply {
                            this.id = it.first().id
                        })

                    }
                }

            }
            ButtonField(text = "Next") {
                navHostController.navigate(Screen.DATASCREEN)
            }


        }
    }


}
