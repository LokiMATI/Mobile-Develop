package com.example.labapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.labapplication.Product

@Composable
fun ProductScreen(product: Product){
    Card(Modifier.padding(10.dp))
    {
        Column(Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Товар", fontSize = 10.em)

            Column(Modifier.fillMaxWidth()) {
                Text("Название: ${product.name}", Modifier.padding(5.dp))
                Text("Цена: ${product.price}", Modifier.padding(5.dp))
            }
        }
    }
}
