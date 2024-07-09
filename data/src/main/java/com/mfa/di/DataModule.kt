package com.mfa.di

import com.mfa.data.note.INoteRepository
import com.mfa.data.note.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule{
    @Binds
    abstract fun bindNoteRepository(noteRepository: NoteRepository) : INoteRepository
}