package com.example.application.ui.posts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.application.NetworkClient

@Composable
fun PostsScreen(modifier: Modifier, client: NetworkClient)
{
    val vm: PostsViewModel = viewModel()
    val posts by vm.posts.collectAsStateWithLifecycle()

    LazyColumn(modifier)
    {
        items(posts) {post ->
            Card {
                Text(post.title, Modifier.size(20.dp).fillMaxWidth())
                Text(post.username, Modifier.size(10.dp).fillMaxWidth(),
                    fontStyle = FontStyle.Italic)
                Text(post.body, Modifier.size(30.dp).fillMaxWidth()
                    .verticalScroll(rememberScrollState()))
            }
        }
    }
}