package com.example.application.ui.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application.NetworkClient
import com.example.application.models.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostsViewModel(val client: NetworkClient) : ViewModel() {
    private val _posts = MutableStateFlow<List<Post>>(listOf())
    val posts: StateFlow<List<Post>> = _posts
    fun loadPosts() {
        viewModelScope.launch { _posts.value = client.apiService.getPosts() }
    }

}