package com.dailyfocusplanner.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dailyfocusplanner.ui.screens.HomeScreen
import com.dailyfocusplanner.ui.screens.TasksScreen
import com.dailyfocusplanner.ui.screens.WelcomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("tasks") { TasksScreen() }
    }
}

