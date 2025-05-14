package com.example.bellascoffeeapp.orders.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bellascoffeeapp.orders.model.ExtraDto
import com.example.bellascoffeeapp.orders.repo.OrdersRepository
import com.example.bellascoffeeapp.orders.view.OrderDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OrderDetailsViewModel (private val repository: OrdersRepository, val drink: OrderDetails) : ViewModel() {
    private val _extrasList = MutableStateFlow<List<ExtraDto>>(emptyList())
    val extrasList = _extrasList.asStateFlow()

    fun getExtras(){
        viewModelScope.launch {
            val response = repository.getExtras()
            _extrasList.value = response
        }
    }
}