package com.example.workflow.presentation.pomodoro.components
import android.graphics.Paint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.workflow.presentation.pomodoro.PomodoroViewModel
import com.example.workflow.presentation.ui.theme.WorkFlowTheme
import com.example.workflow.presentation.ui.theme.prime
import com.example.workflow.presentation.ui.theme.second
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CustomCircularProgressIndicator(
    modifier: Modifier = Modifier,
    primaryColor: Color,
    secondaryColor:Color,
    minValue:Int = 0,
    maxValue:Int = 100,
    circleRadius:Float,
    positionValue: Int,
    viewModel: PomodoroViewModel = hiltViewModel()
) {
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    val state = viewModel.state.collectAsState()


    WorkFlowTheme() {


        Box(
            modifier = modifier
                .clickable {
                if (state.value.isRunning) {
                    viewModel.onPause()
                } else {
                    viewModel.onStart()
                }
            },
            contentAlignment = Alignment.Center
        ) {

            Canvas(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val width = size.width
                val height = size.height

                val circleThickness = width / 25f
                circleCenter = Offset(x = width / 2f, y = height / 2f)


                drawCircle(
                    brush = Brush.radialGradient(
                        listOf(
                            primaryColor.copy(0.45f),
                            secondaryColor.copy(0.15f)
                        )
                    ),
                    radius = circleRadius,
                    center = circleCenter
                )


                drawCircle(
                    style = Stroke(
                        width = circleThickness
                    ),
                    color = secondaryColor,
                    radius = circleRadius,
                    center = circleCenter
                )

                drawArc(
                    color = primaryColor,
                    startAngle = 90f,
                    sweepAngle = (360f / maxValue) * positionValue.toFloat(),
                    style = Stroke(
                        width = circleThickness,
                        cap = StrokeCap.Round
                    ),
                    useCenter = false,
                    size = Size(
                        width = circleRadius * 2f,
                        height = circleRadius * 2f
                    ),
                    topLeft = Offset(
                        (width - circleRadius * 2f) / 2f,
                        (height - circleRadius * 2f) / 2f
                    )

                )

                val outerRadius = circleRadius + circleThickness / 2f
                val gap = 15f
                for (i in 0..(maxValue - minValue)) {
                    val color =
                        if (i < positionValue - minValue) primaryColor else secondaryColor
                    val angleInDegrees = i * 360f / (maxValue - minValue).toFloat()
                    val angleInRad = angleInDegrees * PI / 180f + PI / 2f

                    val yGapAdjustment = cos(angleInDegrees * PI / 180f) * gap
                    val xGapAdjustment = -sin(angleInDegrees * PI / 180f) * gap

                    val start = Offset(
                        x = (outerRadius * cos(angleInRad) + circleCenter.x + xGapAdjustment).toFloat(),
                        y = (outerRadius * sin(angleInRad) + circleCenter.y + yGapAdjustment).toFloat()
                    )

                    val end = Offset(
                        x = (outerRadius * cos(angleInRad) + circleCenter.x + xGapAdjustment).toFloat(),
                        y = (outerRadius * sin(angleInRad) + circleThickness + circleCenter.y + yGapAdjustment).toFloat()
                    )

                    rotate(
                        angleInDegrees,
                        pivot = start
                    ) {
                        drawLine(
                            color = color,
                            start = start,
                            end = end,
                            strokeWidth = 1.dp.toPx()
                        )
                    }

                }

            }

            Box(modifier = Modifier
                .size(210.dp)
                .align(Alignment.Center)
                , contentAlignment = Alignment.Center
            ){
                AnimatedVisibility(!state.value.isRunning) {
                    Text(text = "Start", Modifier
                        .align(Alignment.Center)
                        ,
                        fontSize = 40.sp)
                }

                AnimatedVisibility(state.value.isRunning) {
                    Text(text = "Pause", Modifier
                        .align(Alignment.Center)
                        ,
                        fontSize = 40.sp)
                }


            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CustomCircularProgressIndicator(
        modifier = Modifier
            .size(500.dp)
        ,
        primaryColor = prime,
        secondaryColor = second,
        circleRadius = 330f,
        positionValue = 3,
    )
}

