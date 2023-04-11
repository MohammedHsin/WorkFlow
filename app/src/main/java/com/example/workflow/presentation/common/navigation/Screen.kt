package com.example.workflow.presentation.common.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.HomeWork
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.HomeWork
import androidx.compose.material.icons.outlined.Work
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route : String,
    val title : String,
    val icon : ImageVector? = null,
    val icon_focused : ImageVector? = null
){
    object DashBoard : Screen(
        "dashboard",
        "DashBoard",
        Icons.Outlined.Dashboard,
        Icons.Filled.Dashboard
    )

    object Systems : Screen(
        "systems",
        "Systems",
        Icons.Outlined.Work,
        Icons.Filled.Work
    )

    object Pomodoro : Screen(
        "pomodoro",
        "Pomodoro"
    )

}
