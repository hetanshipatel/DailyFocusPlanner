package com.dailyfocusplanner.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dailyfocusplanner.data.model.Task

@Composable
fun TasksScreen() {

    // like: tasks = []
    val tasks = remember { mutableStateListOf<Task>() }

    // like: currentInput = ""
    var taskText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "My Tasks",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // INPUT FIELD
        TextField(
            value = taskText,
            onValueChange = { taskText = it },
            placeholder = { Text("Enter a task") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        // ADD BUTTON
        Button(
            onClick = {
                if (taskText.isNotBlank()) {
                    tasks.add(
                        Task(
                            id = tasks.size + 1,
                            title = taskText
                        )
                    )
                    taskText = ""
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Add")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // TASK LIST
        LazyColumn {
            items(tasks) { task ->
                Text(
                    text = "• ${task.title}",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}
