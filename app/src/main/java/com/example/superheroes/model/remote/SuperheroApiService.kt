package com.example.superheroes.model.remote

import com.example.superheroes.model.data.Superhero
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/* Correct URL and TOKEN */
private const val ACCESS_TOKEN = "461455927790948"
private const val BASE_URL = "https://superheroapi.com/api/$ACCESS_TOKEN/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface SuperheroApiService {
    @GET("{id}")
    suspend fun getHero(@Path("id") id: Int): Superhero
}

object SuperheroApi {
    val retrofitService: SuperheroApiService by lazy {
        retrofit.create(SuperheroApiService::class.java)
    }
}