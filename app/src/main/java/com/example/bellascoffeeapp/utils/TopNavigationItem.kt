package com.example.bellascoffeeapp.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.bellascoffeeapp.profile.view.Profile

data class TopNavigationItem<T : Any>(
    val label: String,
    val route: T,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean? = null
)

val profileIcon = TopNavigationItem(
    label = "Profile",
    route = Profile,
    selectedIcon = Icons.Filled.Person,
    unselectedIcon = Icons.Outlined.Person
)
