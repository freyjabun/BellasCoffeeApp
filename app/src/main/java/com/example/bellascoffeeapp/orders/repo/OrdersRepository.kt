package com.example.bellascoffeeapp.orders.repo

import com.example.bellascoffeeapp.orders.model.OrderItem

interface OrdersRepository {
    suspend fun getOrderItems() : List<OrderItem>
}