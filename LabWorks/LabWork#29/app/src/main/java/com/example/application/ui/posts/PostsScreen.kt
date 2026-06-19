package com.example.application.ui.posts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.application.NetworkClient
import com.example.application.Routes

@Composable
fun PostsScreen(modifier: Modifier, client: NetworkClient, navController: NavController)
{
    val vm: PostsViewModel = viewModel()
    vm.client = client
    vm.loadPosts()
    val posts by vm.posts.collectAsStateWithLifecycle()

    LazyColumn(modifier)
    {
        item{ Button({navController.navigate(Routes.AddPost.route)},
            Modifier.fillMaxWidth()){
            Text("Создать пост")
        }  }
        items(posts) {post ->
            Card(Modifier.fillMaxWidth().background(Color.Gray).padding(3.dp)
                .clickable { navController.navigate("/posts/${post.id}/comments") }) {
                Text(post.title, Modifier.height(20.dp).fillMaxWidth())
                Text(post.username, Modifier.height(20.dp).fillMaxWidth(),
                    fontStyle = FontStyle.Italic)
                Text(post.body, Modifier.height(30.dp).fillMaxWidth()
                    .verticalScroll(rememberScrollState()))
            }
        }
    }
}