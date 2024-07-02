package com.mfa.notes.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mfa.notes.ui.navigation.Screens.LOGIN
import com.mfa.notes.ui.navigation.Screens.SIGNUP
import com.mfa.profile.login.LoginRoute
import com.mfa.profile.signup.SignupRoute

@Composable
fun AppNavigation(modifier: Modifier, navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = LOGIN) {
        composable(LOGIN) {
            LoginRoute(modifier = Modifier.fillMaxSize(), onSignupClick = {
                navController.navigate(SIGNUP)
            })
        }
        composable(SIGNUP){
            SignupRoute(modifier = Modifier.fillMaxSize())
        }
    }

}