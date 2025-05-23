package com.example.bellascoffeeapp.orders.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bellascoffeeapp.orders.model.Drink
import com.example.bellascoffeeapp.orders.model.ExtraDto
import com.example.bellascoffeeapp.orders.repo.OrdersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OrderDetailsViewModel (private val repository: OrdersRepository, private val id: String) : ViewModel() {
    private val _extrasList = MutableStateFlow<List<ExtraDto>>(emptyList())
    val extrasList = _extrasList.asStateFlow()

    private val _drink = MutableStateFlow<List<Drink>>(emptyList())
    val drink = _drink.asStateFlow()


    fun getDrink(){
        viewModelScope.launch {
            val response = repository.getDrinkById(id)
            _drink.value = response
        }
    }

    fun getExtras(){
        viewModelScope.launch {
            val response = repository.getExtras()
            _extrasList.value = response
        }
    }
}