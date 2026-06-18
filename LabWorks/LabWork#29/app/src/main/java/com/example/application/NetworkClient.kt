package com.example.application

import com.example.application.models.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    init {

    }
    private const val BASE_URL: String = "https://forumapi.snowowl.ru"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ForumApi = retrofit.create(ForumApi::class.java)
}