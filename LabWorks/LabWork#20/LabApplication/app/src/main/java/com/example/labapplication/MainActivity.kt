package com.example.labapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.collection.size
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.labapplication.screens.Authorization
import com.example.labapplication.screens.ProductScreen
import com.example.labapplication.screens.Products
import com.example.labapplication.screens.Registration
import com.example.labapplication.ui.theme.LabApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navScreen()
        }
    }
}

@Composable
fun navScreen(){
    val navController = rememberNavController()
    LabApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
            IconButton({
                if (navController.graph.id != navController.graph.findStartDestination().id)
                    navController.popBackStack()
            }, modifier = Modifier.statusBarsPadding()) {
                Icon(Icons.Filled.ArrowBack, "Назад")
            }
        }) { innerPadding ->
            Box(Modifier.padding(innerPadding),
                contentAlignment = Alignment.Center){
                navController(navController)
            }
        }
    }
}

@Composable
fun navController(navController: NavHostController){
    Box(contentAlignment = Alignment.Center){
        NavHost(navController, Routes.Auth.route){
            composable(Routes.Auth.route){
                Authorization(
                    {navController.navigate(Routes.Products.route)},
                    {navController.navigate(Routes.Register.route)})
            }

            composable(Routes.Register.route){
                Registration { navController.navigate(Routes.Auth.route) }
            }

            composable(Routes.Products.route){
                Products(navController)
            }

            composable(Routes.Product.route + "/{name}/{price}",
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                    navArgument("price") { type = NavType.IntType } )
            ){
                    stackEntry ->
                val name = stackEntry.arguments?.getString("name")
                val price = stackEntry.arguments?.getInt("price")

                ProductScreen(Product(name, price))
            }
        }
    }
}

enum class Routes(val route: String){
    Auth("auth"),
    Register("register"),
    Products("products"),
    Product("product")
}