package com.example.viewmodel

import android.R
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodel.ui.theme.ViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewModelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)){
                        CounterView()
                    }
                }
            }
        }
    }
}

@Composable
fun CounterView(vm : CounterViewModel = viewModel()){
    Button({ vm.increment() }){
        Text(vm.count.toString())
    }
}

@Composable
fun Main(vm : UserListViewModel = viewModel()){
    Column {
        UserInput(
            vm.userName,
            vm.userAge,
            { vm.changeName(it) },
            { vm.changeAge(it) },
            {vm.addUser()})

        UserList(vm.users, {vm.deleteUser(it)})
    }
}

@Composable
fun UserInput(userName : String,
              userAge : Int,
              changeName : (String) -> Unit,
              changeAge : (String) -> Unit,
              add : () -> Unit){
    Column{
        OutlinedTextField(userName,
            onValueChange = {changeName(it)})

        OutlinedTextField(userAge.toString(),
            onValueChange = {changeAge(it)})

        Button({ add() }) {
            Text("Добавить")
        }
    }
}

@Composable
fun UserList(users : List<User>, delete : (User) -> Unit){
    LazyColumn(Modifier.fillMaxWidth()) {
        items(users){ u ->
            Text(u.name)
            Text(u.age.toString())
            TextButton({delete(u)}) {
                Text("Удалить")
            }
        }
    }
}