package com.example.labapplaction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.labapplaction.ui.theme.LabApplactionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LabApplactionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/**
 * Выводом приветствия, содержащие имя пользоваеля.
 * @param name Имя пользователя.
 *
 * @since 1.0
 * @author Lucky
 * @sample GreetingPreview
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

/**
 * Отображения работы функции Greeting.
 *
 * @since 1.0
 * @author Lucky
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabApplactionTheme {
        Greeting("Android")
    }
}

/**
 * Деление двух чисел.
 * @param divisible Делимое.
 * @param divider Делитель.
 * @return Частное.
 *
 * @throws ArithmeticException
 *
 * @since 1.0
 * @author Lucky
 * @sample divideExample
 */
fun divide(divisible : Double, divider : Double) : Double {

    if (divider == 0.0)
        throw ArithmeticException("Делить на 0 нельзя")

    return divisible / divider
}

/**
 * Пример работы функции divide.
 *
 * @since 1.0
 * @author Lucky
 */
private fun divideExample(){
    divide(5.0, 2.0) // 2.5
}