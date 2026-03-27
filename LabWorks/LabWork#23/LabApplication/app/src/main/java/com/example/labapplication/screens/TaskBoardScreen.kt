package com.example.labapplication.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController
import com.example.labapplication.Routes
import com.example.labapplication.Task

@Composable
fun TaskBoardScreen(navController: NavHostController,
                    createTaskButton: () -> Unit,
                    modifier: Modifier = Modifier){
    val tasks = remember { mutableListOf<Task>(Task(1,
        "Test",
        "Test",
        "Lucky",
        "Open")) }

    Row(modifier.fillMaxSize()){
        Column{
            for (task in tasks){
                Card(Modifier.clickable{
                    navController.navigate("${Routes.Task.route}/${task.id}")
                }.height(150.dp).width(150.dp)){
                    Column{
                        Text(task.title, fontSize = 5.em)

                        Card{
                            Text(task.status, fontSize = 4.em)

                            Text(task.author, fontSize = 3.em)
                        }

                    }
                }
            }
        }
    }

    Box(contentAlignment = Alignment.BottomEnd,
        modifier = Modifier.fillMaxSize()){
        FloatingActionButton(createTaskButton, Modifier.size(50.dp))
        {
            Icon(Icons.Default.Create, "Создать")
        }
    }
}