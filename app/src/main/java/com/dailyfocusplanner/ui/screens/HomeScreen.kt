package com.dailyfocusplanner.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Your Daily Dashboard", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("tasks") }) {
            Text("Go to Tasks")
        }
    }
}

