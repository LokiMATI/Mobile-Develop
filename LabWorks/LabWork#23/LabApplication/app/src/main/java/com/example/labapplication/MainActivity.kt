package com.example.labapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.labapplication.screens.CreateTaskScreen
import com.example.labapplication.screens.TaskBoardScreen
import com.example.labapplication.screens.TaskScreen
import com.example.labapplication.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Row(Modifier.statusBarsPadding().fillMaxWidth()){
                           Button({navController.navigate(Routes.TaskBoard.route)}){
                               Icon(Icons.Default.Menu, "Меню")
                           }
                        }
                    }) { innerPadding ->
                    Box(Modifier.padding(innerPadding).fillMaxSize()){
                        NavRoute(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun NavRoute(navController: NavHostController){
    Box(contentAlignment = Alignment.Center){
        NavHost(navController = navController, startDestination = Routes.TaskBoard.route){
            composable(Routes.TaskBoard.route) {
                TaskBoardScreen(navController,
                    {navController.navigate(Routes.CreateTask.route)})
            }

            composable(Routes.Task.route + "/{id}",
                arguments = listOf(
                    navArgument("id") { type = NavType.IntType })
            ){
                    stackEntry ->
                val id = stackEntry.arguments?.getInt("id") ?: 0

                TaskScreen(id)
            }

            composable(Routes.CreateTask.route) {
                CreateTaskScreen({navController.navigate(Routes.TaskBoard.route)})
            }
        }
    }
}

enum class Routes(val route: String){
    Task("task"),
    CreateTask("task/create"),
    TaskBoard("board")
}