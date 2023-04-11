package com.example.workflow.presentation.pomodoro

import android.util.Log
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyCircularProgressBar(
    progress: Float, // a value between 0 and 1
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primary,
    strokeWidth: Dp = 4.dp,
    textSize: TextUnit = 13.sp,
    textColor: Color = Color.Black,
    viewModel : PomodoroViewModel = hiltViewModel()
) {
    val isRunning = viewModel.isRunning.collectAsState()
    // create an animated float to animate the progress changes
    val animatedProgress = remember { androidx.compose.animation.core.Animatable(initialValue = 0.9f) }
    LaunchedEffect(progress) {
        // animate to the new progress value
        animatedProgress.animateTo(
            targetValue = progress,
            animationSpec = tween(durationMillis = 500, easing = LinearEasing)
        )
    }
    // create an animated color to change the color based on the progress value
    val animatedColor = remember { Animatable(initialValue = color) }
    LaunchedEffect(animatedProgress.value) {
        // map the progress value to a hue value between 0 and 360 degrees
        val hue = animatedProgress.value * 360f
        // create a color from the hue value using the HSB model
        val newColor = Color(android.graphics.Color.HSVToColor(floatArrayOf(hue, 1f, 1f)))
        // animate to the new color value
        animatedColor.animateTo(
            targetValue = newColor,
            animationSpec = tween(durationMillis = 500, easing = LinearEasing)
        )
    }
    // draw the circular progress bar with the animated values
    Box(
        modifier = modifier
            .aspectRatio(1f) // make it a square
            .fillMaxSize() // fill the available space
            .padding(8.dp), // add some padding
        contentAlignment = Alignment.Center // center the content
    ) {
        CircularProgressIndicator(
            progress = animatedProgress.value,
            modifier = Modifier.scale(9f),
            color = animatedColor.value,
            strokeWidth = strokeWidth,

            )
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "${(animatedProgress.value * 100).toInt()}%",
                fontSize = textSize,
                color = textColor,
                fontWeight = FontWeight.Bold
            )

            Button(onClick = {
                             if(isRunning.value){
                                 viewModel.onPause()
                             }else{viewModel.onStart()}
            }) {
                Text(text = if (isRunning.value) "Stop" else "Start")
            }


            Button(onClick = {viewModel.onReset()} , enabled = isRunning.value) {
                Text(text = "Reset")
            }

        }

    }
}


@Composable
fun PomodoroScreen(viewModel : PomodoroViewModel = hiltViewModel()){

    val time by viewModel.time.collectAsState()
    val isRunning by viewModel.isRunning.collectAsState()

    Column(Modifier
        .fillMaxSize() ,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {




        val _time = time.toFloat()
        val res = _time / 25.0

        MyCircularProgressBar(res.toFloat())

        Text(text = "$time")



    }
}

