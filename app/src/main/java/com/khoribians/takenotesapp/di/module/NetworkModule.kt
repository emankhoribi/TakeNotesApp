package com.khoribians.takenotesapp.di.module

import android.app.Application
import androidx.room.Room
import com.khoribians.takenotesapp.db.TakeNotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application) =
        Room.databaseBuilder(app, TakeNotesDatabase::class.java, "takenote.db").build()
}