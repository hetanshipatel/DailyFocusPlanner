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

    val tasks = remember { mutableStateListOf<Task>() }
    var taskText by remember { mutableStateOf("") }
    var editingTaskId by remember { mutableStateOf<Int?>(null) }
    var editingText by remember { mutableStateOf("") }


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

        // INPUT
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

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {

                    Checkbox(
                        checked = task.isDone,
                        onCheckedChange = { checked ->
                            val index = tasks.indexOf(task)
                            tasks[index] = task.copy(isDone = checked)
                        }
                    )

                    // 🔹 IF this task is being edited
                    if (editingTaskId == task.id) {

                        TextField(
                            value = editingText,
                            onValueChange = { editingText = it },
                            modifier = Modifier.weight(1f)
                        )

                        Button(
                            onClick = {
                                val index = tasks.indexOf(task)
                                tasks[index] = task.copy(title = editingText)
                                editingTaskId = null
                                editingText = ""
                            }
                        ) {
                            Text("Save")
                        }

                    } else {

                        Text(
                            text = task.title,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                        )

                        Button(
                            onClick = {
                                editingTaskId = task.id
                                editingText = task.title
                            }
                        ) {
                            Text("✏️")
                        }

                        Spacer(modifier = Modifier.width(4.dp))

                        Button(
                            onClick = {
                                tasks.remove(task)
                            }
                        ) {
                            Text("❌")
                        }
                    }
                }
            }
        }


    }
}
