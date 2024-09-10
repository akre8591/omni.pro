package com.example.omnipro.data.di.binds

import com.example.omnipro.data.repository.CharactersRepository
import com.example.omnipro.data.repository.CharactersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindCharactersRepository {

    @Binds
    abstract fun bindCharactersRepository(charactersRepositoryImpl: CharactersRepositoryImpl): CharactersRepository
}