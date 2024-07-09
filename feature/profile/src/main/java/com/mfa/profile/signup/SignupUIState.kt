package com.mfa.profile.signup

import com.mfa.ui.BaseUIState

sealed interface SignupUIState : BaseUIState {
    data object OnSuccess : SignupUIState

    data class OnFailure(val message : String) : SignupUIState

}