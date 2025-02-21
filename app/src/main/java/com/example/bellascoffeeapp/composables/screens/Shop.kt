package com.example.bellascoffeeapp.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bellascoffeeapp.composables.ShopCoffeeBags
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
