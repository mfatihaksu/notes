package com.mfa.note.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mfa.data.note.Note

@Composable
fun NotesRoute(modifier: Modifier = Modifier, onDetailClick : ()-> Unit) {

    val notes = listOf(Note("test", "content", categoryId = "asdad"),Note("test", "content", categoryId = "asdad"),Note("test", "content", categoryId = "asdad"),Note("test", "content", categoryId = "asdad"))
    LazyColumn {
        items(notes.size){
            val note = notes[it]
            Text(text = note.title)
            Text(text = note.content)
            Text(text = note.categoryId)

        }
    }
}

@Preview
@Composable
private fun PreviewNotesRoute() {

    NotesRoute(modifier = Modifier.fillMaxSize(), onDetailClick = {

    })
}