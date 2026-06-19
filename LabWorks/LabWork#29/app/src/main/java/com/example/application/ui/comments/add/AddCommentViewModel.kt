package com.example.application.ui.comments.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application.NetworkClient
import com.example.application.models.dto.CommentDto
import kotlinx.coroutines.launch

class AddCommentViewModel : ViewModel() {
    public var client: NetworkClient? = null
    public var postId by mutableStateOf("")
    public var username by mutableStateOf("")
    public var body by mutableStateOf("")

    fun updatePostId(value: String){
        postId = value
    }

    fun updateUsername(value: String){
        username = value
    }

    fun updateBody(value: String){
        body = value
    }

    fun addComment() {
        viewModelScope.launch {
            val comment = CommentDto(postId, username, body)
            client!!.apiService.addComment(comment)
        }
    }
}