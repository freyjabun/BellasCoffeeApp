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

data class Size(
    val id: Int,
    val size: String,
    val price: Int
)

fun SizeDTO.asDomainModel(): Size{
    return Size(
        id = this.id,
        size = this.size,
        price = this.price
    )
}