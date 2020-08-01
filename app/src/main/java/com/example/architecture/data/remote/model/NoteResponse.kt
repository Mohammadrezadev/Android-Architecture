package com.example.architecture.data.remote.model

import com.google.gson.annotations.SerializedName

data class NoteResponse (
    @SerializedName("notes")
    val notes : List<Note>)