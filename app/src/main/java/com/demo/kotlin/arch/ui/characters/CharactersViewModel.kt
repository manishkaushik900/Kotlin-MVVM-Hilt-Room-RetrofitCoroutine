package com.demo.kotlin.arch.ui.characters

import androidx.lifecycle.ViewModel
import com.demo.kotlin.arch.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(repository: CharacterRepository) :
    ViewModel() {

        val characters = repository.getCharacters()
}
