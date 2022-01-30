package com.example.superheroes.model.remote

import com.example.superheroes.model.Superhero
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/* Correct URL and TOKEN */
// private const val ACCESS_TOKEN = ""
// private const val BASE_URL = "https://superheroapi.com/api/$ACCESS_TOKEN/"

private const val BASE_URL = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface SuperheroApiService {
    @GET("all.json")
    suspend fun getAll(): List<Superhero>

    @GET("{id}")
    suspend fun getDetails(id: Int)
}

object SuperheroApi {
    val retrofitService: SuperheroApiService by lazy {
        retrofit.create(SuperheroApiService::class.java)
    }
}