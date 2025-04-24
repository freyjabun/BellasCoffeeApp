package com.example.bellascoffeeapp.orders.model

data class OrderDetails(
    val name: String,
    val price: String,
    val imageUrl: String? = null,
    val extras: List<String>? = null,

)