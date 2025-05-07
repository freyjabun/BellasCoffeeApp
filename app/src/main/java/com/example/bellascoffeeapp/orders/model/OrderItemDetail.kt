package com.example.bellascoffeeapp.orders.model

data class OrderItemDetail(
    val item: OrderItem,
    val extras: List<Extra>,
    val sizes: List<Size>
)