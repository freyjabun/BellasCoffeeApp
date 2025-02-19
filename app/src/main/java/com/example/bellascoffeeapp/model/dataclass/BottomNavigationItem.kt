package com.example.bellascoffeeapp.model.dataclass

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.bellascoffeeapp.composables.screens.Coffee
import com.example.bellascoffeeapp.composables.screens.Home
import com.example.bellascoffeeapp.composables.screens.Shop


data class BottomNavigationItem<T : Any>(
    val title: String,
    val route: T,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

val navItems = listOf(
    BottomNavigationItem(
        title = "Home",
        route = Home,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false,
    ),
    BottomNavigationItem(
        title = "Coffee",
        route = Coffee,
        selectedIcon = Icons.Filled.Check,
        unselectedIcon = Icons.Outlined.Check,
        hasNews = false,
    ),
    BottomNavigationItem(
        title = "Shop",
        route = Shop,
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart,
        hasNews = false,
    )

)