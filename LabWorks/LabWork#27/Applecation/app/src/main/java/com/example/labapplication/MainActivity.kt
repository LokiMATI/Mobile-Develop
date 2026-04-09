package com.example.labapplication

import android.os.Bundle
import android.provider.ContactsContract
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.labapplication.data.UserViewModel
import com.example.labapplication.screens.AuthorizationScreen
import com.example.labapplication.screens.ProfileScreen
import com.example.labapplication.screens.RegistrationScreen
import com.example.labapplication.ui.theme.LabApplicationTheme

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
fun Main(){
    val navController = rememberNavController()
    val vm = UserViewModel()
    LabApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(Modifier.fillMaxSize().padding(innerPadding)){
                NavHost(navController, Routes.Authorization.route){
                    composable(Routes.Registration.route) {
                        RegistrationScreen(vm,
                            {navController.navigate(Routes.Authorization.route)},
                            {navController.navigate(Routes.Authorization.route)})
                    }

                    composable(Routes.Authorization.route) {
                        AuthorizationScreen(vm,
                            {navController.navigate(Routes.Profile.route)},
                            {navController.navigate(Routes.Registration.route)})
                    }

                    composable(Routes.Profile.route) {
                        ProfileScreen(vm
                        ) { navController.navigate(Routes.Authorization.route) }
                    }
                }
            }
        }
    }
}

enum class Routes(val route: String){
    Registration("registration"),
    Authorization("auth"),
    Profile("profile")
}