package com.example.labapplication

data class TaskBoard(
    var title: String,
    var tasks: MutableList<Task>
)