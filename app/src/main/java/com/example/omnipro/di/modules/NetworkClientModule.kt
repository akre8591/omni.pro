package com.example.omnipro.di.modules

import com.apollographql.apollo.ApolloClient
import com.example.omnipro.data.utils.Constants.SERVER_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkClientModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(SERVER_URL)
            .build()
    }
}