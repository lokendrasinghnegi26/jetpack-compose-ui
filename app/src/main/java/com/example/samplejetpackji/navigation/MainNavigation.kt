package com.example.samplejetpackji.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.samplejetpackji.FirstScreen
import com.example.samplejetpackji.FormScreen
import com.example.samplejetpackji.SecondScreen
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavigation() {

    val navHostController = rememberAnimatedNavController()
    val mainViewModel:MainViewModel = viewModel()


    NavHost(navController = navHostController, startDestination = Screen.FIRST_SCREEN) {
        composable(Screen.FIRST_SCREEN) {
            FirstScreen(navHostController)
        }
        composable(Screen.SECOND_SCREEN) {
            SecondScreen(navHostController)
        }
        composable(Screen.FORM){
            FormScreen(navHostController = navHostController)
        }
    }

}

object Screen {
    const val FIRST_SCREEN = "firstScreen"
    const val SECOND_SCREEN = "secondScreen"
    const val FORM="login_form"
}

class MainViewModel : ViewModel(){

}