package com.example.workflow.presentation.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.SettingsSystemDaydream
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route : String,
    val title : String,
    val icon : ImageVector
){
    object DashBoard : BottomBarScreen(
        route = "dash_board" ,
        title = "Dashboard" ,
        icon = Icons.Default.Home)

    object Systems : BottomBarScreen(
        route = "systems" ,
        title = "Systems" ,
        icon = Icons.Default.SettingsSystemDaydream)
}
