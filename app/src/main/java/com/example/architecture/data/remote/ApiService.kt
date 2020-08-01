package com.example.architecture.data.remote

import com.example.architecture.data.remote.model.NoteResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

//haman kar dao ra anjam midahad
    @GET("note")
    fun getNotes() : Call<NoteResponse>

}