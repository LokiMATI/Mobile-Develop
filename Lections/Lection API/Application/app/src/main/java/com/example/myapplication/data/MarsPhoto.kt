package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class MarsPhoto (
    val id: String,
    @SerializedName("img_src")
    val imgSrc: String
)

