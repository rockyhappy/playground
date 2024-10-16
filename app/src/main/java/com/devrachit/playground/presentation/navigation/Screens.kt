package com.devrachit.playground.presentation.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Model3D: Screen("model_3d")
    object AutoCompleteComponent: Screen("auto_complete_component")
    object MagicDrawer: Screen("magic_drawer")
}