package com.example.bellascoffeeapp.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bellascoffeeapp.shop.model.CoffeeDto
import com.example.bellascoffeeapp.shop.model.ShopItemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShopItemViewModel(
    private val repo: ShopItemRepository
) : ViewModel() {
    private val _shopItemList = MutableStateFlow<List<CoffeeDto>>(emptyList())
    val shopItemList = _shopItemList.asStateFlow()

    fun getShopItems(){
        viewModelScope.launch {
            val response = repo.getShopItems()
            _shopItemList.value = response
        }
    }
}