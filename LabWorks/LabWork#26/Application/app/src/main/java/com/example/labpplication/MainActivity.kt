package com.example.labpplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.labpplication.components.UserInfo
import com.example.labpplication.components.UsersList
import com.example.labpplication.ui.theme.LabpplicationTheme
import com.example.labpplication.viewmodel.UserViewModel

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
fun Main(vm: UserViewModel = viewModel()){
    val navController = rememberNavController()
    LabpplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(Modifier.padding(innerPadding)){
                NavHost(navController, startDestination = Routes.UsersList.route){
                    composable(Routes.UsersList.route) {
                        UsersList(navController, vm)
                    }
                    composable(Routes.UserInfo.route + "/{login}",
                        arguments = listOf(navArgument("login")
                        {type = NavType.StringType}))
                    { stackEntry ->
                        val login = stackEntry.arguments?.getString("login")

                        UserInfo(login!!,
                            {navController.navigate(Routes.UsersList.route)},
                            vm)
                    }
                }
            }
        }
    }
}

enum class Routes(val route: String){
    UsersList("users"),
    UserInfo("users")
}