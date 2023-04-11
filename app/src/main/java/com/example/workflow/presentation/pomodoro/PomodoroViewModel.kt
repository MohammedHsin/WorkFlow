package com.example.workflow.presentation.pomodoro

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.concurrent.timer

class PomodoroViewModel : ViewModel(){

    private val _time = MutableStateFlow(25)
    val time : StateFlow<Int> = _time


    private val _isRunning = MutableStateFlow(false)
    val isRunning : StateFlow<Boolean> = _isRunning

    private var timerJob : Job? = null

    fun onStart(){
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (time.value > 0){
                delay(1000)
                _time.value--
            }
        }
    }

    fun onStop(){
        timerJob?.cancel()
    }

}