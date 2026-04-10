package com.example.myapplication

import android.R.attr.type
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.data.ExerciseViewModel
import com.example.myapplication.screens.CreateExerciseScreen
import com.example.myapplication.screens.ExercisesListScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun Main(vm: ExerciseViewModel = viewModel()){
    val navController = rememberNavController()
    MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(Modifier.padding(innerPadding)){
                NavHost(navController, Routes.ExercisesList.route){
                    composable(Routes.ExercisesList.route) {
                        ExercisesListScreen(vm,
                            {navController.navigate(Routes.CreateExercise.route)},
                            navController)
                    }

                    composable(Routes.CreateExercise.route) {
                        CreateExerciseScreen(vm)
                        { navController.navigate(Routes.ExercisesList.route) }
                    }

                    composable(Routes.ExerciseProfile.route + "/{id}",
                        arguments = listOf(navArgument("id"){ type = NavType.IntType })) {
                        stackEntry ->
                        val id = stackEntry.arguments?.getInt("id")
                        CreateExerciseScreen(vm)
                        { navController.navigate(Routes.ExercisesList.route) }
                    }
                }
            }
        }
    }
}

enum class Routes(val route: String){
    CreateExercise("create"),
    ExercisesList("exercises"),
    ExerciseProfile("exercise")
}