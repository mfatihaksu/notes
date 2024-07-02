package com.mfa.profile.signup

 interface BaseUIState {
    data object Loading : BaseUIState
}

sealed interface SignupUIState : BaseUIState{
    data object OnSuccess : SignupUIState

    data class OnFailure(val message : String) : SignupUIState

}