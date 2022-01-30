package com.example.superheroes.model.remote

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET

/* Correct URL and TOKEN */
// private const val ACCESS_TOKEN = ""
// private const val BASE_URL = "https://superheroapi.com/api/$ACCESS_TOKEN/"

private const val BASE_URL = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface SuperheroApiService {
    @GET("all.json")
    suspend fun getAll(): String

    @GET("{id}")
    suspend fun getDetails(id: Int)
}

object SuperheroApi {
    val retrofitService: SuperheroApiService by lazy {
        retrofit.create(SuperheroApiService::class.java)
    }
}