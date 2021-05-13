package com.demo.kotlin.arch.data.repository

import com.demo.kotlin.arch.data.remote.CharacterRemoteDataSource
import com.demo.kotlin.arch.local.CharacterDao
import com.demo.kotlin.arch.utils.performGetOperation
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val remoteDataSource: CharacterRemoteDataSource,
    private val localDataSource: CharacterDao
) {

    fun getCharacter(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getCharacter(id) },
        networkCall = { remoteDataSource.getCharacter(id) },
        saveCallResult = { localDataSource.insert(it) }
    )

    fun getCharacters()= performGetOperation(
        databaseQuery = {localDataSource.getAllCharacters()},
        networkCall = {remoteDataSource.getCharacters()},
        saveCallResult = {localDataSource.insertAll(it.results)}
    )

}