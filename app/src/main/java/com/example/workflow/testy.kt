package com.example.workflow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workflow.presentation.ui.theme.WorkFlowTheme

@Preview
@Composable
fun BottomNav(){
    WorkFlowTheme() {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color.Cyan)
                .clip(RoundedCornerShape(22.dp))
        ) {
            Item(
                modifier = Modifier
                    .size(50.dp), icon = Icons.Filled.Dashboard
            )
            Item(icon = Icons.Default.SettingsSystemDaydream,
            outerModifier = Modifier
                .clip(RoundedCornerShape(22.dp))
                .padding(10.dp)
                .background(Color.White))

        }
    }
}


@Composable
fun Item(modifier: Modifier = Modifier ,outerModifier: Modifier = Modifier, icon : ImageVector){
    Box(modifier = outerModifier){
        IconButton(onClick = {}) {
            Icon(imageVector = icon, contentDescription = ""
                , modifier = modifier)
        }
    }

}