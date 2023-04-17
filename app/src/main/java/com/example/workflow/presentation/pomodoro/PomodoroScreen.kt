package com.example.workflow.presentation.pomodoro

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.unit.sp
import com.example.workflow.presentation.pomodoro.components.CustomCircularProgressIndicator
import com.example.workflow.presentation.pomodoro.components.TimePicker
import com.example.workflow.presentation.ui.theme.*
import com.example.workflow.util.TimeMapper

@Composable
fun PomodoroScreen(viewModel : PomodoroViewModel = hiltViewModel()){


    val state by viewModel.state.collectAsState()

    val _time = ((state.time.toFloat() / state.amount) * 100).toInt()

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFfffdd0))
        ,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {

        AnimatedVisibility(visible = state.inSession) {
            Text(text = TimeMapper.formatTime(state.time) , fontSize = 40.sp)
        }
        AnimatedVisibility(visible = !state.inSession) {
            TimePicker(time = state.amount , onTimeChange = {
                viewModel.amountChange(it)
            })
        }

        
                CustomCircularProgressIndicator(
                    modifier = Modifier
                        .size(250.dp),
                    primaryColor = prime,
                    secondaryColor = second,
                    circleRadius = 230f,
                    positionValue = _time,

                )
        


        AnimatedVisibility(visible = state.inSession) {
            Button(onClick = {
                viewModel.onReset()
            }) {
                Text(text = "Reset")
            }
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