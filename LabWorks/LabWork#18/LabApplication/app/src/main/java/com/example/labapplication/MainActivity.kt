package com.example.labapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.modifiers.TextAutoSizeLayoutScope
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Label
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import androidx.core.graphics.drawable.IconCompat
import com.example.labapplication.ui.theme.LabApplicationTheme
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Task1(Modifier.padding(innerPadding))
                     Task2(Modifier.padding(innerPadding))
                    //Task3(Modifier.padding(innerPadding))
                    //Task4(Modifier.padding(innerPadding))
                    //Task5(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Task1(modifier : Modifier = Modifier){
    Column(modifier){

        var count by remember { mutableIntStateOf(0) }

        Button({count++},
            shape = RoundedCornerShape(15.dp)
        ) {
            Text("Test")
        }

        OutlinedButton({count++},
            shape = RoundedCornerShape(50.dp)) {
            Text("Test")
        }

        TextButton({count++},
            shape = RoundedCornerShape(30.dp)) {
            Text("Text")
        }

        var color by remember { mutableStateOf(Color(
            Random.nextInt(255),
            Random.nextInt(255),
            Random.nextInt(255))) }

        OutlinedButton({color = Color(
            Random.nextInt(255),
            Random.nextInt(255),
            Random.nextInt(255))
            count++},
            colors = ButtonDefaults.buttonColors(color))
        {
            Text("Поменять цвет")
        }

        Text("$count")
    }
}

@Composable
fun Task2(modifier: Modifier = Modifier){
    var count by remember { mutableIntStateOf(0) }
    val products = Array(100,{i -> "Товар #$i"})
    Column(modifier.fillMaxSize()){

        Box(Modifier.fillMaxWidth().weight(0.8f)){
            Column(modifier = Modifier
                .verticalScroll(rememberScrollState())
                ) {
                for (product in products) {
                    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                        Text("$product", fontSize = 30.sp)
                        Button({ count++ }) {
                            Icon(Icons.Default.ShoppingCart, "")
                        }
                    }
                }
            }
        }
        Box(Modifier.fillMaxWidth().weight(0.2f)){Text("$count")}
    }
}

@Composable
fun Task3(modifier: Modifier = Modifier){
    var count by remember { mutableIntStateOf(0) }
    val product by remember { mutableStateOf(Product("Товар", 100)) }

    Column(modifier.fillMaxSize()){

        Text("Название ${product.title}\nЦена: ${product.price}" +
                "\nКоличество: ${count}\nИтоговая стоимость: ${count * product.price}",
            fontSize = 30.sp)
        Row{
            IconButton ({ count++ }, enabled = count < 10) {
                Icon(Icons.Filled.Add, "")
            }
            IconButton ({ count-- }, enabled = count > 0) {
                Icon(Icons.Filled.Delete, "")
            }
        }

    }
}

class Product(val title : String, val price : Int)

@Composable
fun Task4(modifier: Modifier = Modifier){
    val phones = Array(100,{"+0(000)000-00-00"})
    Box{
        Box(Modifier.fillMaxWidth()){
            Column(modifier = Modifier
                .verticalScroll(rememberScrollState())
            ) {
                for (phone in phones) {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly) {
                        TextButton({}) { Text(phone, fontSize = 30.sp)}
                    }
                }
            }
        }
        Box(Modifier.fillMaxSize().padding(50.dp),contentAlignment = Alignment.BottomEnd){
            Row{
                FloatingActionButton({}) { Icon(Icons.Filled.Call, "")}
                FloatingActionButton({}) { Icon(Icons.Filled.Email, "")}
            }
        }
    }
}

@Composable
fun Task5(modifier: Modifier = Modifier){
    val tasks = remember { mutableStateListOf<Task>( Task("Task #1"), Task("Task #2")) }
    var newName by remember { mutableStateOf("") }
    Column(modifier.fillMaxSize()){

        Box(Modifier.fillMaxWidth()){
            Column(modifier = Modifier
                .verticalScroll(rememberScrollState())
            ) {
                for (i in tasks.indices) {
                    val task = tasks[i]
                    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                        Checkbox(task.isComplite, {
                            tasks[i] = Task(task.name, !task.isComplite) })
                        Text(task.name, fontSize = 30.sp)
                    }
                }
            }
        }
    }
    Box(Modifier.fillMaxSize().padding(50.dp), contentAlignment = Alignment.BottomEnd){
        Column {
            Row{
                ExtendedFloatingActionButton(icon = {
                    Icon(Icons.Filled.Add, "Добавить")},
                    text = {Text("Добавить")},
                    onClick = {tasks.add(Task(newName))})
            }
            OutlinedTextField(newName,
                {newName = it},
                modifier = Modifier.width(160.dp),
                singleLine = true)
        }
    }
}

data class Task(val name : String, var isComplite : Boolean = false);