package com.example.architecture.data.remote.model

import com.google.gson.annotations.SerializedName

data class Note (
    @SerializedName("id")
    val id :Long ,
    @SerializedName("title")
    val title :String ,
    @SerializedName("body")
val body : String,
    @SerializedName("dateTime")
    val dateTime: String,
    @SerializedName("categories")
    val categories: List<Category>

)