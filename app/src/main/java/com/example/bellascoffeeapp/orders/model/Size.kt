package com.example.bellascoffeeapp.orders.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SizeDTO(
    @SerialName("size_id")
    val id: Int,
    @SerialName("size_name")
    val size: String,
    @SerialName("size_price")
    val price: Int
)

@Serializable
data class Size(
    val id: Int,
    val size: String,
    val price: Int
)

@Serializable
data class OrderItemSize(
    @SerialName("order_item_id")
    val orderItemId: Int,
    @SerialName("size_id")
    val sizes: SizeDTO
)

fun SizeDTO.toDomainModel(): Size{
    return Size(
        id = this.id,
        size = this.size,
        price = this.price
    )
}