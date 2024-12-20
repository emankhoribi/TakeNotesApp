package com.khoribians.takenotesapp.di.module

import com.khoribians.takenotesapp.db.TakeNotesDatabase
import com.khoribians.takenotesapp.repository.CreateNoteRepository
import com.khoribians.takenotesapp.repository.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    fun provideCreateNoteRepo(db: TakeNotesDatabase): CreateNoteRepository =
        CreateNoteRepository(db)

    @Provides
    fun provideNotesRepo(db: TakeNotesDatabase): NotesRepository =
        NotesRepository(db)

}