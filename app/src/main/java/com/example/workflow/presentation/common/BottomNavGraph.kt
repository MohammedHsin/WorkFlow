package com.example.workflow.presentation.common

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.workflow.presentation.DashBoard.DashBoardScreen
import com.example.workflow.presentation.Systems.SystemsScreen


@Composable
fun BottomNavGraph(navController : NavHostController){

    NavHost(navController = navController , startDestination = BottomBarScreen.DashBoard.route){

        composable(BottomBarScreen.DashBoard.route){
            DashBoardScreen()
        }

        composable(BottomBarScreen.Systems.route){
            SystemsScreen()
        }
    }
}