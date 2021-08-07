package com.example.first_compose.data.remote


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)