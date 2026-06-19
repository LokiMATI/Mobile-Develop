package com.example.application.ui.comments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.application.NetworkClient

@Composable
fun CommentsScreen(modifier: Modifier,
                   client: NetworkClient,
                   id: String,
                   onCreate: () -> Unit,
                   onBack: () -> Unit)
{
    val vm: CommentsViewModel = viewModel()
    vm.client = client
    vm.currentPostId = id
    vm.loadComments()
    val comments by vm.comments.collectAsStateWithLifecycle()

    Column(Modifier.fillMaxSize()){
        LazyColumn(modifier)
        {
            item {
                Button(onCreate, Modifier.fillMaxWidth()) {
                    Text("Создать комментарий")
                }
            }
            items(comments) { comment ->
                Card(Modifier.fillMaxWidth().background(Color.Gray).padding(3.dp)) {
                    Text(comment.username, Modifier.height(20.dp).fillMaxWidth(),
                        fontStyle = FontStyle.Italic)
                    Text(comment.body, Modifier.height(30.dp).fillMaxWidth()
                        .verticalScroll(rememberScrollState()))
                }
            }
        }
        Button(onBack, Modifier.fillMaxWidth()){
            Text("Назад")
        }
    }

}