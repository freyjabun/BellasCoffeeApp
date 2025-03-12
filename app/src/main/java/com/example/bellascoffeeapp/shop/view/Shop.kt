package com.example.bellascoffeeapp.shop.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bellascoffeeapp.shop.viewmodel.ShopItemViewModel
import com.example.bellascoffeeapp.ui.theme.BellasTheme
import kotlinx.serialization.Serializable

@Composable
fun Shop(viewModel: ShopItemViewModel) {

    val shopItems by viewModel.shopItemList.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.getShopItems()
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(BellasTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(shopItems) { item ->
            ShopItemComposable(item)
        }
    }
}

@Serializable
object Shop
