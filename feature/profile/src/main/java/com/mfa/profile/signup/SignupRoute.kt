package com.mfa.profile.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mfa.profile.R

@Composable
fun SignupRoute(modifier: Modifier = Modifier, onSignup: () -> Unit) {
    SignupScreen(modifier = modifier, onSignup = onSignup)
}

@Composable
internal fun SignupScreen(
    modifier: Modifier = Modifier,
    viewModel: SignupViewModel = hiltViewModel(),
    onSignup: () -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
        ) {
            var nameTextFieldValue by remember {
                mutableStateOf(TextFieldValue(""))
            }
            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(stringResource(R.string.name))
                }, value = nameTextFieldValue, onValueChange = {
                    nameTextFieldValue = it
                    viewModel.updateName(nameTextFieldValue.text)
                })
            Spacer(Modifier.height(16.dp))
            var surNameTextFieldValue by remember {
                mutableStateOf(TextFieldValue(""))
            }
            TextField(modifier = Modifier
                .fillMaxWidth(),
                label = {
                    Text(stringResource(R.string.surname))
                }, value = surNameTextFieldValue, onValueChange = {
                    surNameTextFieldValue = it
                    viewModel.updateSurName(surNameTextFieldValue.text)
                })
            Spacer(Modifier.height(16.dp))
            var emailTextFieldValue by remember {
                mutableStateOf(TextFieldValue(""))
            }
            TextField(
                modifier = Modifier
                    .fillMaxWidth(), label = {
                    Text(stringResource(R.string.email))
                },
                value = emailTextFieldValue,
                onValueChange = {
                    emailTextFieldValue = it
                    viewModel.updateEmail(it.text)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                )
            )
            Spacer(Modifier.height(16.dp))
            var passwordTextFieldValue by remember {
                mutableStateOf(TextFieldValue(""))
            }
            TextField(
                modifier = Modifier
                    .fillMaxWidth(), label = {
                    Text(stringResource(R.string.password))
                },
                value = passwordTextFieldValue,
                onValueChange = {
                    passwordTextFieldValue = it
                    viewModel.updatePassword(it.text)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            var passwordRetryTextFieldValue by remember {
                mutableStateOf(TextFieldValue(""))
            }
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                label = {
                    Text(stringResource(R.string.confirm_password))
                }, value = passwordRetryTextFieldValue, onValueChange = {
                    passwordRetryTextFieldValue = it
                    viewModel.updatePasswordRetry(it.text)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )
            Spacer(Modifier.height(32.dp))
            Button(onClick = {
                viewModel.signup(onSignup = onSignup)
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp), content = {
                    Text(stringResource(R.string.signup))
                })
        }
    }
}