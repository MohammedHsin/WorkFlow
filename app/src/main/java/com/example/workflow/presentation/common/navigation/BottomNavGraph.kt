package com.example.workflow.presentation.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.workflow.presentation.DashBoard.DashBoardScreen
import com.example.workflow.presentation.Systems.SystemsScreen
import com.example.workflow.presentation.pomodoro.PomodoroScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(navController = navController , startDestination = Screen.DashBoard.route){

        composable(Screen.DashBoard.route){
            DashBoardScreen()
        }

        composable(Screen.Systems.route){
            SystemsScreen(navController)
        }

        composable(Screen.Pomodoro.route){
            PomodoroScreen()
        }
    }
}
