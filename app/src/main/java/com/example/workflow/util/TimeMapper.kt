package com.example.workflow.util

object TimeMapper {


    fun formatTime(seconds: Int): String {
        // Assume that seconds is a positive integer
        // Convert seconds to minutes and seconds
        val minutes = seconds / 60
        val seconds = seconds % 60
        // Format the output string with leading zeros if needed
        return String.format("%02d:%02d", minutes, seconds)
    }
}