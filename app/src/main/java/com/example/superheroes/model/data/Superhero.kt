package com.example.superheroes.model.data

data class Superhero(
    val appearance: Appearance = Appearance(),
    val biography: Biography = Biography(),
    val connections: Connections = Connections(),
    val id: Int? = 0,
    val images: Images = Images(),
    val name: String? = "",
    val powerstats: Powerstats = Powerstats(),
    val slug: String? = "",
    val work: Work = Work()
) {
    data class Powerstats(
        val combat: Int? = 0,
        val durability: Int? = 0,
        val intelligence: Int? = 0,
        val power: Int? = 0,
        val speed: Int? = 0,
        val strength: Int? = 0
    )

    data class Appearance(
        val eyeColor: String? = "",
        val gender: String? = "",
        val hairColor: String? = "",
        val height: List<String>? = listOf(),
        val race: String? = "",
        val weight: List<String>? = listOf()
    )

    data class Biography(
        val aliases: List<String>? = listOf(),
        val alignment: String? = "",
        val alterEgos: String? = "",
        val firstAppearance: String? = "",
        val fullName: String? = "",
        val placeOfBirth: String? = "",
        val publisher: String? = ""
    )

    data class Work(
        val base: String? = "",
        val occupation: String? = ""
    )

    data class Connections(
        val groupAffiliation: String? = "",
        val relatives: String? = ""
    )

    data class Images(
        val lg: String? = "",
        val md: String? = "",
        val sm: String? = "",
        val xs: String? = ""
    )
}