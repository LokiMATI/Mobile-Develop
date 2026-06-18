package com.example.application

import com.example.application.models.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface ForumApi {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}