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
import com.example.samplejetpackji.screen.ShowData
import com.example.samplejetpackji.viewModel.UserViewModel
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavigation(userViewModel:UserViewModel) {

    val navHostController = rememberAnimatedNavController()



    NavHost(navController = navHostController, startDestination = Screen.FIRST_SCREEN) {
        composable(Screen.FIRST_SCREEN) {
            FirstScreen(navHostController)
        }
        composable(Screen.SECOND_SCREEN) {
            SecondScreen(navHostController)
        }
        composable(Screen.FORM){
            FormScreen(navHostController = navHostController,userViewModel)
        }
        composable(Screen.DATASCREEN){
            ShowData(navHostController = navHostController,userViewModel)
        }
    }

}

object Screen {
    const val FIRST_SCREEN = "firstScreen"
    const val SECOND_SCREEN = "secondScreen"
    const val FORM="login_form"
    const val DATASCREEN="show_data"
}

class MainViewModel : ViewModel(){

}