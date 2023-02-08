package com.example.restapplication.network

import com.example.restapplication.model.User
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://gorest.co.in/public/v2/"

//Retrofit Builder and convert Json to user object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .baseUrl(BASE_URL)
    .build()

//Interface which inform how use API
interface RestApiService{
    @GET("users")
    suspend fun getUsers(): List<User>
}

object RestApi{
    val retrofitService: RestApiService by lazy {
        retrofit.create(RestApiService::class.java)
    }
}

