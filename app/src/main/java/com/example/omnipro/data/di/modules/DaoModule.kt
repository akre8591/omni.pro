package com.example.omnipro.data.di.modules

import com.example.omnipro.data.local.dao.CharactersDao
import com.example.omnipro.data.local.db.OmniProDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun provideCharactersDao(omniProDatabase: OmniProDatabase): CharactersDao =
        omniProDatabase.charactersDao()
}