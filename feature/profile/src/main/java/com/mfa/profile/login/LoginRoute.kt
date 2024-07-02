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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mfa.feature.profile.R

@Composable
fun LoginRoute(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = hiltViewModel(),
    onSignupClick: () -> Unit
) {
    LoginScreen(modifier = modifier, onSignupClick = onSignupClick)
}

@Composable
internal fun LoginScreen(modifier: Modifier = Modifier, onSignupClick: () -> Unit) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
        ) {
            TextField(modifier = Modifier
                .fillMaxWidth()
                .height(42.dp), label = {
                Text(stringResource(R.string.user_name))
            }, value = TextFieldValue(
                text = ""
            ), onValueChange = {

            })
            Spacer(Modifier.height(16.dp))
            TextField(modifier = Modifier
                .fillMaxWidth()
                .height(42.dp), label = {
                Text(stringResource(R.string.password))
            }, value = TextFieldValue(
                text = ""
            ), onValueChange = {

            })
            Spacer(Modifier.height(32.dp))
            Button(onClick = {

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
        }
    }
}