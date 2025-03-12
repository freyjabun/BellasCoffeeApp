package com.example.bellascoffeeapp.shop.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bellascoffeeapp.shop.model.ShopItem
import com.example.bellascoffeeapp.shop.model.ShopItemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShopItemViewModel(
    private val repo: ShopItemRepository
) : ViewModel() {
    private val _shopItemList = MutableStateFlow<List<ShopItem>>(emptyList())
    val shopItemList = _shopItemList.asStateFlow()

    fun getShopItems(){
        viewModelScope.launch {
            val response = repo.getShopItems()
            _shopItemList.value = response
        }
    }
}