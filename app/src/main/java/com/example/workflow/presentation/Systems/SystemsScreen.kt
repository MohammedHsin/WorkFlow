package com.example.workflow.presentation.Systems

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workflow.presentation.Systems.components.GridItem


@Composable
fun SystemsScreen(){
    LazyVerticalGrid(columns = GridCells.Adaptive(140.dp), content = {
        items(10){
            GridItem(icon = Icons.Filled.Home, title = "Testy Item")
        }
    })
}

@Preview(showBackground = true)
@Composable
fun pre(){
    SystemsScreen()
}