package com.mfa.profile.login

import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val mShowWarningMessage = MutableStateFlow(false)
    val showWarningMessage = mShowWarningMessage.asStateFlow()

    private fun updateWarningMessage(state : Boolean) {
        mShowWarningMessage.update {
            state
        }
    }

    private fun validateLogin(email : String, password: String):Boolean{
        return !(email.isEmpty() || password.isEmpty())
    }

    fun login(email: String, password: String, onLoggedIn: () -> Unit) {
        updateWarningMessage(false)
        if (validateLogin(email, password).not()){
            updateWarningMessage(true)
            return
        }
        val auth = Firebase.auth
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onLoggedIn()
                } else {
                    updateWarningMessage(true)
                }
            }
    }

}