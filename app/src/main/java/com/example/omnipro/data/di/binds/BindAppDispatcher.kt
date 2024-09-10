package com.example.omnipro.data.di.binds

import com.example.omnipro.data.utils.AppDispatcher
import com.example.omnipro.data.utils.AppDispatcherImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindAppDispatcher {

    @Binds
    @Singleton
    abstract fun bindAppDispatcher(appDispatcherImpl: AppDispatcherImpl): AppDispatcher
}