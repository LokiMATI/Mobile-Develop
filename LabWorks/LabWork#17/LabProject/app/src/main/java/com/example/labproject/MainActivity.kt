package com.example.labproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labproject.ui.theme.LabProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier
                        .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally){
                        //Registration()

                        //PinCode()

                        //AboutMe()

                        TextExample()
                    }
                }
            }
        }
    }
}

@Composable
fun Registration(){
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var age by remember { mutableIntStateOf(0) }
    var site by remember { mutableStateOf("https://") }
    var outputMessage by remember { mutableStateOf("") }
    var isAgree by remember { mutableStateOf(false) }

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        OutlinedTextField(login, {login = it}, label = {Text("Логин")},
            placeholder = {Text("Login")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))

        OutlinedTextField(password, {password = it}, label = {Text("Пароль")},
            placeholder = {Text("12345")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))

        OutlinedTextField(confirmPassword, {confirmPassword = it},
            label = {Text("Подтверждение пароля")},
            placeholder = {Text("12345")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))

        OutlinedTextField(phone, {phone = it},
            label = {Text("Номер телефона")},
            placeholder = {Text("+7(777)666-66-66")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))

        OutlinedTextField(email, {email = it}, label = {Text("Email")},
            placeholder = {Text("example@example.com")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))

        OutlinedTextField("$age", {age = it.toInt()}, label = {Text("Возраст")},
            placeholder = {Text("18")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

        OutlinedTextField(site, {site = it},
            label = {Text("Персональный сайт")},
            placeholder = {Text("https://example.com")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri))

        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            Checkbox(isAgree, {isAgree = it})
            Text("Я согласен на обработку своих персональных данных и принимаю условия " +
                    "Политики конфиденциальности и Пользовательского соглашения")
        }


        Button({if (login.trim() != "" && password.trim() != ""
            && confirmPassword.trim() != "" && phone.trim() != "" && email.trim() != ""
            && age >= 0 && site.trim() != "") outputMessage = "$login, вы зарегистрированы"
        else outputMessage = "Не все поля заполнены"}, Modifier, enabled = isAgree) {
            Text("Зарегистрироваться")
        }

        if (outputMessage != ""){
            Text(outputMessage)
        }
    }
}

@Composable
fun PinCode(){
    val pinCode = "5930"
    var inputCode by remember { mutableStateOf("") }
    var outputMessage by remember { mutableStateOf("") }
    var tryCount by remember { mutableIntStateOf(3) }

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        OutlinedTextField(inputCode, {if (it.length <= 4) inputCode = it},
            label = {Text("Пин-код")},
            placeholder = {Text("0000")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            enabled = tryCount > 0)

        Button({if (inputCode == pinCode) outputMessage = "Верно"
            else {outputMessage = "Не верно"; if (tryCount > 0) tryCount--}}) { Text("Отправить") }

        if (outputMessage != ""){
            Text("$outputMessage. Осталось попыток: $tryCount")
        }
    }
}

@Composable
fun AboutMe(){

    var text by remember { mutableStateOf("") }
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start){

        OutlinedTextField(text, {if (it.length <= 300) text = it},
            label = {Text("О себе")},
            placeholder = {Text("Что-то о себе")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            minLines = 9,
            maxLines = 9,
            modifier = Modifier.fillMaxWidth(1f))

        Text("${300 - text.length}")
    }
}

@Composable
fun TextExample(){
    val colors = listOf(Color.Red, Color.Blue, Color.Magenta, Color.Green, Color.Cyan)
    var selectedOption by remember { mutableStateOf(colors[0]) }
    var size by remember { mutableFloatStateOf(16f) }
    var isBold by remember { mutableStateOf(false) }
    var isItalic by remember { mutableStateOf(false) }

    Column {
        Text("Тестовый текст", fontSize = size.sp, modifier = Modifier.padding(10.dp),
            color = selectedOption,
            fontWeight = if (isBold) FontWeight.Bold else null,
            fontStyle = if (isItalic) FontStyle.Italic else null)
        Column(Modifier.selectableGroup()) {
            colors.forEach { color ->
                Row( Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically)
                {
                    RadioButton(
                        selected = (color == selectedOption),
                        onClick = { selectedOption = color }
                    )
                    Box(Modifier.size(20.dp).background(color))
                }
            }
        }

        Column(){
            Slider(size,
                valueRange = 10f..30f,
                steps = 20, onValueChange = {size = it})
            Text("$size")
        }



        Row (verticalAlignment = Alignment.CenterVertically){
            Text("Полужирный",
                fontSize = 22.sp)
            Switch(
                checked = isBold,
                onCheckedChange = {
                    isBold = it
                }
            )
        }

        Row (verticalAlignment = Alignment.CenterVertically){
            Text("Курсив",
                fontSize = 22.sp)
            Switch(
                checked = isItalic,
                onCheckedChange = {
                    isItalic = it
                }
            )
        }
    }
}