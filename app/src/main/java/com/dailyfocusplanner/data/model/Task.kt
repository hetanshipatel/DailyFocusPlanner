package com.dailyfocusplanner.data.model

data class Task(
    val id: Int,
    val title: String,
    val isDone: Boolean = false
)

