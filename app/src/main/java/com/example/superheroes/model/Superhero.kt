package com.example.superheroes.model

import com.example.superheroes.model.subclasses.*

data class Superhero(
    val id: String,
    val name: String,
    val slug: String,
    val powerstats: PowerStats,
    val appearance: Appeareance,
    val biography: Biography,
    val work: Work,
    val connections: Connections,
    val images: Images
)