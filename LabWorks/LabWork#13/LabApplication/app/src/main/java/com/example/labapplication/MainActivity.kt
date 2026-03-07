package com.example.labapplication

import android.os.Bundle
import android.webkit.WebSettings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.labapplication.screens.Auth
import com.example.labapplication.ui.theme.LabApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Auth()
//            LabApplicationTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Task2Column(Modifier.padding(innerPadding))
//                }
//            }
        }
    }
}

@Composable
fun Greeting(group: String, modifier: Modifier = Modifier) {
    Text(
        "Привет, $group!",
        modifier = modifier,
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        color = Color.Red
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabApplicationTheme {
        Greeting("Android")
    }
}

@Composable
fun Task2(){
    Text("Добро пожаловать")
    Button({}) {
        Text("ОК")
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Column(modifier: Modifier = Modifier){
    Column(modifier) {

        Task2()
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Row(modifier: Modifier = Modifier){
    Row(modifier) {

        Task2()
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Box(modifier: Modifier = Modifier){
    Box(modifier) {

        Task2()
    }
}

@Preview(showBackground = true)
@Composable
fun Task3Box(){
    Box(modifier = Modifier.fillMaxSize())
    {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .align(Alignment.TopStart)
                .size(100.dp, 150.dp)
        )

        Box(
            modifier = Modifier
                .background(Color.Cyan)
                .align(Alignment.TopCenter)
                .size(100.dp, 150.dp)
        )

        Box(
            modifier = Modifier
                .background(Color(255, 165, 0))
                .align(Alignment.TopEnd)
                .size(100.dp, 150.dp)
        )

        Box(
            modifier = Modifier
                .background(Color.Green)
                .align(Alignment.CenterStart)
                .size(100.dp, 150.dp)
        )

        Box(
            modifier = Modifier
                .background(Color.Magenta)
                .align(Alignment.CenterEnd)
                .size(100.dp, 150.dp)
        )

        Box(
            modifier = Modifier
                .background(Color.Blue)
                .align(Alignment.BottomStart)
                .size(100.dp, 150.dp)
        )

        Box(
            modifier = Modifier
                .background(Color.Gray)
                .align(Alignment.BottomCenter)
                .size(100.dp, 150.dp)
        )

        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .align(Alignment.BottomEnd)
                .size(100.dp, 150.dp)
        )

        Box(
            modifier = Modifier
                .background(Color.Gray)
                .align(Alignment.BottomCenter)
                .size(100.dp, 150.dp)
        )

        Box(
            modifier = Modifier
                .background(Color.Black)
                .align(Alignment.Center)
                .size(250.dp, 750.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Task3Column(){
Column(modifier = Modifier.fillMaxSize()) {
    Box(
        Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .weight(0.05f)
    ) {
        Text(
            "5%",
            color = Color.White,
            fontSize = 30.sp
        )
    }

    Box(
        Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .weight(0.15f)
    ) {
        Text(
            "15%",
            color = Color.Black,
            fontSize = 30.sp
        )
    }

    Box(
        Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .weight(0.3f)
    ) {
        Text(
            "30%",
            color = Color.White,
            fontSize = 30.sp
        )
    }

    Box(
        Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .weight(0.5f)
    ) {
        Text(
            "50%",
            color = Color.Black,
            fontSize = 30.sp
        )
    }
}
}

@Preview(showBackground = true)
@Composable
fun Task5(){
    val strings = arrayOf("Test1", "Test2", "Test3", "Test4", "Test5")
    Column(Modifier.fillMaxSize())
    {
        for (string in strings){
            Text(
                string,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(Color.Cyan),
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }
    }
}