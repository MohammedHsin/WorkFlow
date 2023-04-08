package com.example.workflow.presentation.common.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController


@Composable
fun BottomNav(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController = navController)}
    ) {
        Modifier.padding(it)
        BottomNavGraph(navController = navController)
    }
}