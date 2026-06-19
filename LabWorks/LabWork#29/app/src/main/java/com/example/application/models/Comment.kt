package com.example.application.models

data class Comment(
    val id: String,
    val postId: String,
    val username: String,
    val body: String
)