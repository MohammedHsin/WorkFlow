package com.example.workflow.presentation.pomodoro

data class PomodoroState(
    val time : Int = 25,
    val isRunning : Boolean = false,
    val inSession : Boolean = false,
    val amount : Int = 25
)