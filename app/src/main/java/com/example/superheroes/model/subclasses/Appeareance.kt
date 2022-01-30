package com.example.superheroes.model.subclasses

data class Appeareance(
    val gender: String,
    val race: String?,
    val height: List<String>,
    val weight: List<String>,
    val eyeColor: String,
    val hairColor: String
)