package com.example.omnipro.data.di.binds

import com.example.omnipro.data.utils.NetworkApi
import com.example.omnipro.data.utils.NetworkApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindNetworkApi {
    @Binds
    @Singleton
    abstract fun bindNetworkApi(networkApiImpl: NetworkApiImpl): NetworkApi
}
