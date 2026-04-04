package com.example.databaseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.databaseapp.ui.theme.DataBaseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
        }
    }
}

@Composable
fun Main(vm: PlayerViewModel = viewModel()) {
    val players by vm.playerList.observeAsState(listOf())
    DataBaseAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(Modifier.padding(innerPadding)) {
                OutlinedTextField(vm.playerName,
                    {vm.changeName(it)},
                    label = {Text("Name")})

                OutlinedTextField(vm.playerLevel.toString(),
                    {vm.changeLevel(it)},
                    label = {Text("Level")})

                Button({vm.addPlayer()}){
                    Text("Добавить")
                }

                LazyColumn(Modifier.fillMaxWidth()) {
                    items(items = players){ p ->
                        Row(Modifier.fillMaxWidth().padding(8.dp)){
                            Text(p.id.toString(), Modifier.weight(1f))
                            Text(p.name.toString(), Modifier.weight(2f))
                            Text(p.level.toString(), Modifier.weight(2f))

                            TextButton({vm.deletePlayer(p)}) {
                                Text("Удалить")
                            }
                        }

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    Main()
}