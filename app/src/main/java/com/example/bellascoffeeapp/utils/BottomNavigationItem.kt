package com.example.bellascoffeeapp.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.bellascoffeeapp.homepage.view.Home
import com.example.bellascoffeeapp.orders.view.Order
import com.example.bellascoffeeapp.shop.view.Shop


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
        title = "Order",
        route = Order,
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