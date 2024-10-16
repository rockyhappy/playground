package com.devrachit.playground.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devrachit.playground.presentation.screens.custom_auto_complete.CustomAutoComplete
import com.devrachit.playground.presentation.screens.homeScreen.HomeScreen
import com.devrachit.playground.presentation.screens.magic_drawer.MagicDrawer
import com.devrachit.playground.presentation.screens.model3d.Model3dScreen

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(){
                navController.navigate(it)
            }
        }
        composable(Screen.Model3D.route) {
            Model3dScreen()
        }
        composable(Screen.AutoCompleteComponent.route) {
            CustomAutoComplete()
        }
        composable(Screen.MagicDrawer.route) {
            MagicDrawer()
        }
    }
}