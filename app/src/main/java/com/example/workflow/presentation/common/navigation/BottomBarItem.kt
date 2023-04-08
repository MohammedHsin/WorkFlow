package com.example.workflow.presentation.common.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController


@Composable
fun RowScope.AddItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navHostController: NavHostController
){
    val selected = currentDestination?.hierarchy?.any{it.route == screen.route} == true

    val background = if (selected) MaterialTheme.colors.primary.copy(alpha = 0.6f)
    else Color.Transparent


    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = {
                navHostController.navigate(screen.route) {
                    popUpTo(navHostController.graph.findStartDestination().id)
                }
            })
    ) {

        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp , vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ){
            
            Icon(imageVector = if (selected) screen.icon_focused else screen.icon
                , contentDescription = "",
            tint = LocalContentColor.current)

            AnimatedVisibility(visible = selected) {
                Text(text = screen.title , color = LocalContentColor.current)
            }
        }
    }

}






