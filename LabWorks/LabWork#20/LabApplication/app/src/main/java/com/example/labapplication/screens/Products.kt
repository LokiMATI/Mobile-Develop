package com.example.labapplication.screens

import androidx.compose.foundation.clickable
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
import androidx.navigation.NavHostController
import com.example.labapplication.Product
import com.example.labapplication.Routes

@Composable
fun Products(navController: NavHostController){
    val products = mutableListOf(Product("АК-47", 47),
        Product("АК-123", 123),
        Product("АК-28", 28),
        Product("АК-50", 50),
        Product("АК-101", 101),
        Product("Шоколад", 500),
        Product("Шкода", 2000),
        Product("АЗС", 20),
        Product("Книга 'Т'", 1000),
        Product("Сыр", 100))

    Column(Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Список товаров")

        for (product in products){
            Card(Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .clickable {
                    navController.navigate(
                        "${Routes.Product.route}/${product.name}/${product.price}")
                })
            { product.name?.let { Text(it, Modifier.padding(5.dp)) } }
        }
    }
}
