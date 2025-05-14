package com.example.bellascoffeeapp.orders.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bellascoffeeapp.orders.model.DrinkDto
import com.example.bellascoffeeapp.orders.model.ExtraDto
import com.example.bellascoffeeapp.orders.repo.OrdersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OrderDetailsViewModel (private val repository: OrdersRepository, val drink: DrinkDto) : ViewModel() {
    private val _extrasList = MutableStateFlow<List<ExtraDto>>(emptyList())
    val extrasList = _extrasList.asStateFlow()

    fun getExtras(){
        viewModelScope.launch {
            val response = repository.getExtras()
            _extrasList.value = response
        }
    }
}