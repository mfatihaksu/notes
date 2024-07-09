package com.mfa.data.note

import kotlinx.coroutines.flow.Flow

interface INoteRepository {

    suspend fun getNotes() : Flow<List<Note>>
}