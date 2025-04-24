package com.example.bellascoffeeapp.orders.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrderItemDTO(
    @SerialName("id")
    val id: Int,
    @SerialName("order_name")
    val name: String,
    @SerialName("order_price")
    val price: Int,
    @SerialName("order_image")
    val imageUrl: String? = null,
    @SerialName("order_type")
    val orderType: String
)

data class OrderItem(
    val id: Int,
    val name: String,
    val price: Int,
    val imageUrl: String? = null,
    val orderType: String
)

fun OrderItemDTO.asDomainModel(): OrderItem{
    return OrderItem(
        id = this.id,
        name = this.name,
        price = this.price,
        imageUrl = this.imageUrl,
        orderType = this.orderType
    )
}

