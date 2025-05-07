package com.example.bellascoffeeapp.orders.repo

import com.example.bellascoffeeapp.orders.model.OrderItemDetail

interface OrdersRepository {
    suspend fun getOrderItems() : List<OrderItemDetail>
}