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


    private val _state = MutableStateFlow(PomodoroState())
    val state : StateFlow<PomodoroState> = _state

    private var timerJob : Job? = null

    fun onStart(){
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            _state.value = _state.value.copy(isRunning = true , inSession = true)
            while (_state.value.time > 0){
                delay(1000)
                _state.value = _state.value.copy(time = _state.value.time -1)
            }

            _state.value = _state.value.copy(isRunning = false , inSession = false , time = _state.value.amount)
        }
    }

    fun onPause(){
        timerJob?.cancel()
        _state.value = _state.value.copy(isRunning = false)
    }

    fun onReset(){
        timerJob?.cancel()
        _state.value = _state.value.copy(time = _state.value.amount)
        _state.value = _state.value.copy(isRunning = false , inSession = false)
    }

    fun amountChange(newAmount : Int){
        _state.value = _state.value.copy(amount = newAmount , time = newAmount)
    }

}