package com.mfa.data.note

import kotlinx.coroutines.flow.Flow

interface INoteRepository {

    suspend fun getNotes() : Flow<List<Note>>

    suspend fun createNote()

    suspend fun getNote(id: String) : Flow<Note>

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(id : String)
}