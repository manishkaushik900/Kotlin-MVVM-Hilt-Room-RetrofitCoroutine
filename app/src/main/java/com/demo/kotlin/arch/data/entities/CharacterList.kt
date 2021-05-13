package com.demo.kotlin.arch.data.entities
import com.demo.kotlin.arch.data.entities.Character
data class CharacterList(
    val info: Info,
    val results: List<Character>
)