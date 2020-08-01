package com.example.architecture.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private const val BASE_URL="http://192.168.2.26:9000/api/"

    private  val retrofit : Retrofit

            get() {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)

                val okHttpClient =  OkHttpClient()
                    .newBuilder()
                    .addInterceptor(logging)
                    .build()


             val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()

                return  retrofit
            }


    val apiService:ApiService = retrofit.create(ApiService::class.java)

}