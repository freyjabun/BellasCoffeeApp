package com.example.bellascoffeeapp.orders.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bellascoffeeapp.orders.model.Category
import com.example.bellascoffeeapp.orders.repo.OrdersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OrdersViewModel(private val repo: OrdersRepository) : ViewModel() {

    private val _categorisedDrinksList = MutableStateFlow<List<Category>>(emptyList())
    val categorisedDrinksList = _categorisedDrinksList.asStateFlow()
    
    fun getCategorisedDrinks(){
        viewModelScope.launch {
            val response = repo.getDrinksCategorised()
            _categorisedDrinksList.value = response
        }
    }
}