package com.example.application

import com.example.application.models.Comment
import com.example.application.models.Post
import com.example.application.models.dto.CommentDto
import com.example.application.models.dto.PostDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ForumApi {
    @GET("/posts")
    suspend fun getPosts(): List<Post>

    @GET("/posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId: String) : List<Comment>

    @POST("/posts")
    suspend fun addPost(@Body post: PostDto) : Unit

    @POST("/comments")
    suspend fun addComment(@Body comment: CommentDto) : Unit
}