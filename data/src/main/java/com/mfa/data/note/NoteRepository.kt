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
}