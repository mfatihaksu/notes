package com.mfa.note.home

import com.mfa.data.note.Note
import com.mfa.ui.BaseUIState

interface HomeUIState : BaseUIState {
    data class OnNotesListed(val notes : List<Note>) : HomeUIState

    data class OnFailure(val message : String) : HomeUIState
}