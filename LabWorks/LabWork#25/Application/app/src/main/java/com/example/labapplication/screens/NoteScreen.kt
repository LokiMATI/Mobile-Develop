package com.example.labapplication.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.nio.file.Files

@Composable
fun NoteScreen(context : Context = LocalContext.current){
    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    val files = remember { File(context.filesDir, "app_notes")
        .listFiles()!!.toCollection(ArrayList()) }
    var state by remember { mutableStateOf(false) }

    state.let {
        Column(Modifier.fillMaxSize()){
            OutlinedTextField(title, {title = it}, Modifier.fillMaxWidth(),
                label = {Text("Заголовок")},
                singleLine = true)

            OutlinedTextField(text, {text = it}, Modifier.fillMaxWidth(),
                label = {Text("Текст")},
                minLines = 10,
                maxLines = 10)

            Button({
                    val directory = File(context.filesDir, "app_notes")
                    if (!directory.exists())
                        directory.mkdirs()

                    val file = File(directory, title)
                    try {
                        val outputStream = FileOutputStream(file)
                        outputStream.write(text.toByteArray())
                        outputStream.close()
                    } catch (e : IOException){
                }
            }){
                Text("Сохранить")
            }

            Column(Modifier.height(200.dp).verticalScroll(rememberScrollState())
                .fillMaxWidth()) {
                for (file in files){
                    if (!file.isFile)
                        continue

                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                        Text(file.name, Modifier.clickable{
                            title = file.name
                            text = context.assets
                                .open(file.path)
                                .bufferedReader().use {it.readText()}
                        })

                        IconButton({
                            file.delete()
                        }) {
                            Icon(Icons.Default.Delete, "Удалить")
                        }
                    }
                }
            }
        }
    }

}