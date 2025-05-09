package com.example.bellascoffeeapp.orders.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bellascoffeeapp.orders.model.DrinkDto
import com.example.bellascoffeeapp.orders.model.ExtraDto
import com.example.bellascoffeeapp.orders.repo.OrdersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OrdersViewModel(private val repo: OrdersRepository) : ViewModel() {
    private val _drinksList = MutableStateFlow<List<DrinkDto>>(emptyList())
    val drinkList = _drinksList.asStateFlow()

    private val _extrasList = MutableStateFlow<List<ExtraDto>>(emptyList())
    val extrasList = _extrasList.asStateFlow()

    fun getOrders(){
        viewModelScope.launch {
            val response = repo.getDrinks()
            _drinksList.value = response
        }
    }

    fun getExtras(){
        viewModelScope.launch {
            val response = repo.getExtras()
            _extrasList.value = response
        }
    }
}