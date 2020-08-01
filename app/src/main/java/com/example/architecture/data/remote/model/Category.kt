package com.example.architecture.data.remote.model

import android.icu.text.CaseMap
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category (
    @SerializedName("id")
    val id : Long,
    @SerializedName ("title")
    val title: String


):Serializable