package com.example.omnipro.di.binds

import com.example.omnipro.data.remote.charactersclient.CharactersClient
import com.example.omnipro.data.remote.charactersclient.CharactersClientImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindCharactersClient {

    @Binds
    abstract fun bindCharactersClient(charactersClientImpl: CharactersClientImpl): CharactersClient
}