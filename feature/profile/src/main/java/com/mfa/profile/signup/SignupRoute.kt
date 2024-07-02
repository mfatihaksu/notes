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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mfa.feature.profile.R

@Composable
fun SignupRoute(modifier: Modifier = Modifier) {
    SignupScreen(modifier = modifier)
}

@Composable
internal fun SignupScreen(
    modifier: Modifier = Modifier,
    viewModel: SignupViewModel = hiltViewModel()
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
        ) {
            val name = viewModel.name.collectAsState()
            TextField(modifier = Modifier
                .fillMaxWidth()
                .height(42.dp), label = {
                Text(stringResource(R.string.name))
            }, value = TextFieldValue(
                text = name.value.orEmpty()
            ), onValueChange = {
                viewModel.updateName(it.text)
            })
            Spacer(Modifier.height(16.dp))
            val surname = viewModel.surName.collectAsState()
            TextField(modifier = Modifier
                .fillMaxWidth()
                .height(42.dp), label = {
                Text(stringResource(R.string.surname))
            }, value = TextFieldValue(
                text = surname.value.orEmpty()
            ), onValueChange = {
                viewModel.updateSurName(it.text)
            })
            Spacer(Modifier.height(16.dp))
            val email = viewModel.email.collectAsState()
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp), label = {
                    Text(stringResource(R.string.email))
                }, value = TextFieldValue(
                    text = email.value.orEmpty()
                ), onValueChange = {
                    viewModel.updateEmail(it.text)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                )
            )
            Spacer(Modifier.height(16.dp))
            val password = viewModel.password.collectAsState()
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp), label = {
                    Text(stringResource(R.string.password))
                }, value = TextFieldValue(
                    text = password.value.orEmpty()
                ), onValueChange = {
                    viewModel.updatePassword(it.text)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            val passwordRetry = viewModel.passwordRetry.collectAsState()
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp), label = {
                    Text(stringResource(R.string.confirm_password))
                }, value = TextFieldValue(
                    text = passwordRetry.value.orEmpty()
                ), onValueChange = {
                    viewModel.updatePasswordRetry(it.text)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )
            Spacer(Modifier.height(32.dp))
            Button(onClick = viewModel::signup,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp), content = {
                    Text(stringResource(R.string.signup))
                })
        }
    }
}