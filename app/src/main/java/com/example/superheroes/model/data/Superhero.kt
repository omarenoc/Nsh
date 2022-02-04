package com.example.superheroes.model.data

import com.squareup.moshi.Json

data class Superhero(
    val appearance: Appearance = Appearance(),
    val biography: Biography = Biography(),
    val connections: Connections = Connections(),
    val id: String = "",
    @Json(name = "image")
    val images: Images = Images(),
    val name: String? = "",
    val powerstats: Powerstats = Powerstats(),
    val response: String? = "",
    val work: Work = Work()
) {
    data class Powerstats(
        val combat: String? = "",
        val durability: String? = "",
        val intelligence: String? = "",
        val power: String? = "",
        val speed: String? = "",
        val strength: String? = ""
    )

    data class Appearance(
        @Json(name = "eye-color")
        val eyeColor: String? = "",
        val gender: String? = "",
        @Json(name = "hair-color")
        val hairColor: String? = "",
        val height: List<String>? = listOf(),
        val race: String? = "",
        val weight: List<String>? = listOf()
    )

    data class Biography(
        val aliases: List<String>? = listOf(),
        val alignment: String? = "",
        @Json(name = "alter-egos")
        val alterEgos: String? = "",
        @Json(name = "first-appearance")
        val firstAppearance: String? = "",
        @Json(name = "full-name")
        val fullName: String? = "",
        @Json(name = "place-of-birth")
        val placeOfBirth: String? = "",
        val publisher: String? = ""
    )

    data class Work(
        val base: String? = "",
        val occupation: String? = ""
    )

    data class Connections(
        @Json(name = "group-affiliation")
        val groupAffiliation: String? = "",
        val relatives: String? = ""
    )

    data class Images(
        val url: String = ""
    )
}