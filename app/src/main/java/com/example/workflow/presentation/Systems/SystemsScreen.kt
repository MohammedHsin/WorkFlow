package com.example.workflow.presentation.Systems

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.workflow.presentation.Systems.components.GridItem



@Composable
fun SystemsScreen(){
    Column() {

        LazyVerticalGrid(columns = GridCells.Adaptive(140.dp), content = {
            items(10) {
                GridItem(icon = Icons.Filled.Home, title = "Testy Item")
            }
        })
    }}


@Preview(showBackground = true)
@Composable
fun pre(){
    LazyGridWithPrettyCards()
}

@Composable
fun PrettyCard(title: String, icon: ImageVector) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

    }
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                color = Color.Black
            )
        }
    }
}

@Composable
fun LazyGridWithPrettyCards() {
    val items = listOf(
        Pair("Title 1", Icons.Default.Home),
        Pair("Title 2", Icons.Default.Favorite),
        Pair("Title 3", Icons.Default.Settings),
        Pair("Title 4", Icons.Default.ShoppingCart),
        Pair("Title 5", Icons.Default.Person),
        Pair("Title 5", Icons.Default.Person)
    )

    LazyVerticalGrid(GridCells.Fixed(2)) {
        items(items.size) { index ->
            PrettyCard(title = items[index].first, icon = items[index].second)
        }
    }
}