package com.example.myapplication.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.Routes
import com.example.myapplication.data.ExerciseViewModel

@Composable
fun ExercisesListScreen(
    vm: ExerciseViewModel,
    createButton: () -> Unit,
    navController: NavController){
    val list by vm.exercisesList!!.observeAsState(listOf())
    Column(Modifier.fillMaxSize()){
        Button(createButton) {
            Text("Создать упражнение")
        }
        LazyColumn {
            items(items = list){ i ->
                Card(Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(Routes.ExerciseProfile.route + "/${i.id}")
                    }) {
                    Column{
                        Text(i.title)
                        Text(i.category)
                        Text("${i.duration} минут")
                        Text("${i.burnCalories} калорий")
                    }
                }
            }
        }
    }

}