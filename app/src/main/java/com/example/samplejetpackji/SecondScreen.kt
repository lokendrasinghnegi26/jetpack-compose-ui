package com.example.samplejetpackji

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun SecondScreen(
    navHostController: NavHostController
) {
    navHostController.previousBackStackEntry?.savedStateHandle?.get<String>("name")?.let {
        Box(modifier = Modifier.run {
            fillMaxSize()
        }) {
            Text(text = it)
        }
    }
}