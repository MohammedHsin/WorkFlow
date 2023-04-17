package com.example.workflow.presentation.pomodoro.components

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.chargemap.compose.numberpicker.NumberPicker


@Composable
fun TimePicker(time : Int , onTimeChange : (Int) -> Unit){
    NumberPicker(value = time, onValueChange = {onTimeChange(it)}, range = 1..60)
}