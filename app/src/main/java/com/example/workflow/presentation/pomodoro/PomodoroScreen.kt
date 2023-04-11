package com.example.workflow.presentation.pomodoro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun PomodoroScreen(viewModel : PomodoroViewModel = hiltViewModel()){

    val time by viewModel.time.collectAsState()
    val isRunning by viewModel.isRunning.collectAsState()

    Column(Modifier
        .fillMaxSize() ,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "$time")

        Button(onClick = {
            if(isRunning){
                viewModel.onPause()
            }
            else{
                viewModel.onStart()
            }
        }) {
            Text(text = if (isRunning) "Stop" else "Start")
        }
    }
}