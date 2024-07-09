package com.mfa.profile.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mfa.profile.R

@Composable
fun LoginRoute(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    onSignupClick: () -> Unit,
    onLoggedIn: () -> Unit
) {
    LoginScreen(modifier = modifier, viewModel = viewModel, onSignupClick = onSignupClick, onLoggedIn = onLoggedIn)
}

@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    onSignupClick: () -> Unit,
    onLoggedIn: () -> Unit
) {
    val showWarningMessage = viewModel.showWarningMessage.collectAsState()
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
        ) {
            var emailTextFieldValue by remember {
                mutableStateOf(TextFieldValue())
            }
            TextField(modifier = Modifier
                .fillMaxWidth(),
                label = {
                    Text(stringResource(R.string.email))
                }, value = emailTextFieldValue, onValueChange = {
                    emailTextFieldValue = it
                })
            Spacer(Modifier.height(16.dp))
            var passwordTextFieldValue by remember {
                mutableStateOf(TextFieldValue())
            }
            TextField(modifier = Modifier
                .fillMaxWidth(),
                label = {
                    Text(stringResource(R.string.password))
                }, value = passwordTextFieldValue,
                onValueChange = {
                    passwordTextFieldValue = it
                })
            Spacer(Modifier.height(32.dp))
            Button(onClick = {
                viewModel.login(
                    email = emailTextFieldValue.text,
                    password = passwordTextFieldValue.text,
                    onLoggedIn = onLoggedIn
                )
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp), content = {
                    Text(stringResource(R.string.login))
                })
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onSignupClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp), content = {
                    Text(stringResource(R.string.signup))
                })
            if (showWarningMessage.value){
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = stringResource(id = R.string.invalid_login_message), color = Color.Red)
            }
        }
    }
}