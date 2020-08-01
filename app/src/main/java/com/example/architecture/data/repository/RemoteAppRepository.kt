package com.example.architecture.data.repository

import android.util.Log
import com.example.architecture.AppConstants
import com.example.architecture.data.remote.RetrofitService
import com.example.architecture.data.remote.model.NoteResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteAppRepository private constructor(){
    companion object{
       private val singleInstance : RemoteAppRepository = RemoteAppRepository()
        fun getinstanced():RemoteAppRepository{
            return singleInstance
        }
    }


fun getNotes(){
    RetrofitService.apiService.getNotes().enqueue(object :Callback<NoteResponse>{
        override fun onFailure(call: Call<NoteResponse>, t: Throwable) {
            t.message?.let { Log.i(AppConstants.NETWORK_TEST , it) }
        }

        override fun onResponse(call: Call<NoteResponse>, response: Response<NoteResponse>) {

            response.headers().get("white")?.let { Log.i(AppConstants.NETWORK_TEST , it) }

 if (response.isSuccessful){
     response.body()?.notes?.forEach { Log.i(AppConstants.NETWORK_TEST ,  it.toString()  ) }
 }
        }
    })
}





}