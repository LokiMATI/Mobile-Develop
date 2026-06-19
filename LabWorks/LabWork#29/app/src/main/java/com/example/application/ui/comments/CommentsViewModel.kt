package com.example.application.ui.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application.NetworkClient
import com.example.application.models.Comment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CommentsViewModel : ViewModel() {
    public var client: NetworkClient? = null
    public var currentPostId : String? = null
    private val _comments = MutableStateFlow<List<Comment>>(listOf())
    val comments: StateFlow<List<Comment>> = _comments
    fun loadComments() {
        viewModelScope.launch { _comments.value = client!!.apiService.getComments(currentPostId!!) }
    }
}