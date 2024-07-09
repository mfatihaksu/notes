package com.mfa.profile.signup

import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.mfa.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor() : ViewModel() {

    private val mName = MutableStateFlow<String?>(null)
    val name = mName.asStateFlow()

    fun updateName(name: String?) {
        mName.update {
            name
        }
    }

    private val mSurName = MutableStateFlow<String?>(null)
    private val surName = mSurName.asStateFlow()

    fun updateSurName(surName: String?) {
        mSurName.update {
            surName
        }
    }

    private val mEmail = MutableStateFlow<String?>(null)
    val email = mEmail.asStateFlow()

    fun updateEmail(email: String?) {
        mEmail.update {
            email
        }
    }

    private val mPassword = MutableStateFlow<String?>(null)
    val password = mPassword.asStateFlow()

    fun updatePassword(password: String?) {
        mPassword.update {
            password
        }
    }

    private val mPasswordRetry = MutableStateFlow<String?>(null)
    val passwordRetry = mPasswordRetry.asStateFlow()

    fun updatePasswordRetry(passwordRetry: String?) {
        mPasswordRetry.update {
            passwordRetry
        }
    }

    fun signup(onSignup: () -> Unit) {
       Firebase.auth.createUserWithEmailAndPassword(
            email.value.orEmpty(),
            password.value.orEmpty()
        )
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    saveUser(onSignup = onSignup, onFailure = {
                        showFailMessage()
                    })
                }
            }
    }

    private fun showFailMessage(){

    }

    private fun saveUser(onSignup: () -> Unit, onFailure: () -> Unit) {
        Firebase.firestore.collection("users")
            .add(
                User(
                    name = name.value.orEmpty(),
                    surName = surName.value.orEmpty(),
                    email = email.value.orEmpty(),
                    password = password.value.orEmpty()
                )
            )
            .addOnSuccessListener {
                onSignup()
            }
            .addOnFailureListener {
                onFailure()
            }
    }

}