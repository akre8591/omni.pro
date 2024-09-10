package com.example.omnipro.data.di.modules

import android.content.Context
import androidx.room.Room
import com.example.omnipro.data.local.db.OmniProDatabase
import com.example.omnipro.data.utils.Constants.LOCAL_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomInstance(@ApplicationContext context: Context): OmniProDatabase =
        Room.databaseBuilder(
            context,
            OmniProDatabase::class.java, LOCAL_DATABASE_NAME
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
}