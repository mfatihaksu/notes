package com.mfa.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(val route : String,val icon : ImageVector, val label : String)

val bottomNavigationItems = listOf(
    BottomNavItem("notes", Icons.Default.Home, "Home"),
    BottomNavItem("category", Icons.Default.Settings, "Category"),
    BottomNavItem("profile", Icons.Default.Person, "Profile")
)