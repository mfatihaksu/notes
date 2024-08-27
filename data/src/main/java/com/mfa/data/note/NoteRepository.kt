package com.mfa.data.note

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class NoteRepository @Inject constructor() : INoteRepository {
    override suspend fun getNotes(): Flow<List<Note>> {
        Firebase.firestore.collection("notes").get().addOnSuccessListener {result->
            if (result.isEmpty){

            }

        }
        return emptyFlow()
    }

    override suspend fun createNote() {
        TODO("Not yet implemented")
    }

    override suspend fun getNote(id: String): Flow<Note> {
        TODO("Not yet implemented")
    }

    override suspend fun updateNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(id: String) {
        TODO("Not yet implemented")
    }
}