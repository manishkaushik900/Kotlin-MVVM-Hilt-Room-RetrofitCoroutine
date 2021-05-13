package com.demo.kotlin.arch.entities
import com.demo.kotlin.arch.entities.Character
data class CharacterList(
    val info: Info,
    val results: List<Character>
)