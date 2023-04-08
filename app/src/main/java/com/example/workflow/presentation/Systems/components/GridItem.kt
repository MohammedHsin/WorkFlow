package com.example.workflow.presentation.Systems.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timelapse
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workflow.presentation.ui.theme.WorkFlowTheme

@Composable
fun GridItem(icon : ImageVector , title : String) {
    WorkFlowTheme() {

        Card(
            modifier = Modifier
                .padding(20.dp)
                .size(100.dp, 70.dp)
                .clip(RoundedCornerShape(15))
                .background(MaterialTheme.colors.primary)

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(MaterialTheme.colors.primary)
            ) {
                Icon(imageVector = icon, contentDescription = "")
                Text(text = title)
            }
        }
    }
}

@Preview
@Composable
fun pre(){
    GridItem(icon = Icons.Filled.Timelapse, title = "Pomodoro")
}