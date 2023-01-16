package com.example.samplejetpackji

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun FormScreen(navHostController: NavHostController) {
    val context = LocalContext.current
    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
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

                Toast.makeText(context,"loginpage",Toast.LENGTH_SHORT).show()
            }


        }
    }


}
