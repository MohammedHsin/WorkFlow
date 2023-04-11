package com.example.workflow.di

import com.example.workflow.presentation.pomodoro.PomodoroViewModel
import dagger.hilt.InstallIn
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    fun providePomodoroViewModel() = PomodoroViewModel()

}