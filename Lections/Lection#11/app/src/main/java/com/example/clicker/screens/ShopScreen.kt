package com.example.clicker.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clicker.GameViewModel
import com.example.clicker.formatNumber
import kotlin.collections.component1
import kotlin.collections.component2

@Composable
fun ShopScreen(vm: GameViewModel){
    Column(Modifier.fillMaxSize()){
        vm.upgrades.forEach { (type, upgrade) ->
            Card(Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable{ vm.onUpgrade(upgrade) }
            ){
                Text(type.title, fontSize = 25.sp,
                    modifier = Modifier.padding(5.dp))

                Text("${upgrade.level}lv. Значение: ${upgrade.currentValue().formatNumber()}",
                    modifier = Modifier.padding(5.dp))

                Text("Стоимость: ${upgrade.currentValue().formatNumber()}",
                    modifier = Modifier.padding(5.dp))
            }
        }
    }
}