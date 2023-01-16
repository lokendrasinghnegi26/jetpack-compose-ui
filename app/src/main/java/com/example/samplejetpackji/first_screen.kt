package com.example.samplejetpackji

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.samplejetpackji.navigation.Screen

@Composable
fun FirstScreen(
    navHostController: NavHostController
) {
    val context = LocalContext.current
    var username by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextInput(text = username, onChange = {
                username = it
            }, label = "Enter username")
            ButtonField(text = "submit") {
                if (username.isNotEmpty()) {
                    navHostController.currentBackStackEntry?.savedStateHandle?.set("name", username)
//                    navHostController.navigate(Screen.SECOND_SCREEN)
                    navHostController.navigate(Screen.FORM)
                } else {
                    Toast.makeText(context, "Enter user name", Toast.LENGTH_SHORT).show()

                }
            }
        }

    }

}
