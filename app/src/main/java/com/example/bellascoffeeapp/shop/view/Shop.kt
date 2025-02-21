package com.example.bellascoffeeapp.shop.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bellascoffeeapp.shop.repo.ShopCoffeeBags
import com.example.bellascoffeeapp.ui.theme.BellasTheme
import kotlinx.serialization.Serializable

@Composable
fun Shop(){
    Box(
        modifier = Modifier.fillMaxSize()
        .background(BellasTheme.colorScheme.background)
    )
    {
        ShopCoffeeBags()
    }
}

@Serializable
object Shop
