package com.example.workflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.workflow.presentation.common.navigation.BottomNav
import com.example.workflow.presentation.ui.theme.WorkFlowTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {


            val systemUiController = rememberSystemUiController()
            SideEffect {
                // navigation bar
                systemUiController.isNavigationBarVisible = false

                // status bar
                systemUiController.isStatusBarVisible = false

                // system bars
                systemUiController.isSystemBarsVisible = false
            }

            WorkFlowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BottomNav()
                }
            }
        }
    }

}


@Composable
@Preview
fun Pre(){
    BottomNav()
}