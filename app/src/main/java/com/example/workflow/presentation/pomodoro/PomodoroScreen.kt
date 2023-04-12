package com.example.workflow.presentation.pomodoro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workflow.presentation.pomodoro.components.CustomCircularProgressIndicator
import com.example.workflow.presentation.ui.theme.*

@Composable
fun PomodoroScreen(viewModel : PomodoroViewModel = hiltViewModel()){


    val time by viewModel.time.collectAsState()
    val isRunning by viewModel.isRunning.collectAsState()

    val _time = ((time.toFloat() / 25.0) * 100).toInt()

    Column(
        Modifier
            .fillMaxSize()
            .background(darkBlue)
        ,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {

                CustomCircularProgressIndicator(
                    modifier = Modifier
                        .size(250.dp),
                    initialValue = 0,
                    primaryColor = blue,
                    secondaryColor = brightBlue,
                    circleRadius = 230f,
                    positionValue = _time,
                    onPositionChange = {

                    }
                )
        
        Button(onClick = {
            viewModel.onStart()
        }) {
            Text("Start")
        }


    }
}

@Preview(showBackground =true)
@Composable
fun Pre(){
    WorkFlowTheme {
        PomodoroScreen()
    }
}