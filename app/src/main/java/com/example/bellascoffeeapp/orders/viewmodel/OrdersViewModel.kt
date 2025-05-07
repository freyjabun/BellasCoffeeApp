package com.example.bellascoffeeapp.orders.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bellascoffeeapp.orders.model.OrderItemDetail
import com.example.bellascoffeeapp.orders.repo.OrdersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OrdersViewModel(private val repo: OrdersRepository) : ViewModel() {
    private val _orderItemList = MutableStateFlow<List<OrderItemDetail>>(emptyList())
    val orderItemList = _orderItemList.asStateFlow()

    fun getOrders(){
        viewModelScope.launch {
            val response = repo.getOrderItems()
            _orderItemList.value = response
        }
    }
}