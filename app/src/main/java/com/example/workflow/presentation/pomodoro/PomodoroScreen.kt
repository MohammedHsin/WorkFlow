package com.example.workflow.presentation.pomodoro

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun PomodoroScreen(viewModel : PomodoroViewModel = hiltViewModel()){

    val time by viewModel.time.collectAsState()

    Column(Modifier.fillMaxSize()) {
        Text(text = "$time")

        Button(onClick = {
            if(time > 0){
                viewModel.onStart()
            }else{
                viewModel.onStop()
            }
        }) {
            Text(text = if (time > 0) "Start" else "Stop")
        }
    }
}