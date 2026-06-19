package com.example.application.ui.posts.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application.NetworkClient
import com.example.application.models.dto.PostDto
import kotlinx.coroutines.launch

class AddPostViewModel : ViewModel() {
    public var client: NetworkClient? = null
    public var title by mutableStateOf("")
    public var username by mutableStateOf("")
    public var body by mutableStateOf("")

    fun updateTitle(value: String){
        title = value
    }

    fun updateUsername(value: String){
        username = value
    }

    fun updateBody(value: String){
        body = value
    }

    fun addComment() {
        viewModelScope.launch {
            val post = PostDto(title, username, body)
            client!!.apiService.addPost(post)
        }
    }
}