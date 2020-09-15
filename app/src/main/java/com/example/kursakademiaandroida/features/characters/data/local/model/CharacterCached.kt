package com.example.kursakademiaandroida.features.characters.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kursakademiaandroida.features.characters.domain.model.Character

@Entity
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    @Embedded
    val origin: OriginCached,
    @Embedded
    val characterLocation: CharacterLocationCached,
    val image: String,
    val episodes: List<String>,
    val url: String
) {
    constructor(character: Character) : this(
        character.id,
        character.name,
        character.status,
        character.species,
        character.type,
        character.gender,
        OriginCached(character.origin),
        CharacterLocationCached(character.characterLocation),
        character.image,
        character.episodes,
        character.url
    )

    companion object

    fun toCharacter() = Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin.toOrigin(),
        characterLocation = characterLocation.toCharacterLocation(),
        image = image,
        episodes = episodes,
        url = url
    )
}
