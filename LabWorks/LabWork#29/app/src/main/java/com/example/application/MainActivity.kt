package com.example.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.application.ui.comments.CommentsScreen
import com.example.application.ui.comments.add.AddCommentScreen
import com.example.application.ui.posts.PostsScreen
import com.example.application.ui.posts.add.AddPostScreen
import com.example.application.ui.theme.ApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val client = NetworkClient;
        enableEdgeToEdge()
        setContent {
            ApplicationTheme {
                Scaffold(Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController, Routes.Posts.route) {
                        composable(Routes.Posts.route)
                        {
                            PostsScreen(Modifier.padding(innerPadding), client, navController)
                        }

                        composable(Routes.AddPost.route)
                        {
                            AddPostScreen(Modifier.padding(innerPadding),
                                client,
                                {navController.navigate(Routes.Posts.route)},
                                {navController.navigate(Routes.Posts.route)})
                        }

                        composable(Routes.Comments.route,
                            listOf(navArgument("id") { type = NavType.StringType }) )
                        { stackEntry ->
                            val id = stackEntry.arguments?.getString("id")
                            CommentsScreen(Modifier.padding(innerPadding),
                                client,
                                id!!,
                                { navController.navigate("/posts/$id/comments/add") },
                                { navController.navigate(Routes.Posts.route) })
                        }

                        composable(Routes.AddComment.route,
                            listOf(navArgument("id") { type = NavType.StringType }) )
                        { stackEntry ->
                            val id = stackEntry.arguments?.getString("id")
                            AddCommentScreen(Modifier.padding(innerPadding),
                                client,
                                id!!,
                                { navController.navigate("/posts/$id/comments") },
                                {navController.navigate("/posts/$id/comments")})
                        }
                    }
                }
            }
        }
    }
}
enum class Routes(val route: String){
    Posts("/posts"),
    AddPost("/posts/add"),
    Comments("/posts/{id}/comments"),
    AddComment("/posts/{id}/comments/add")
}