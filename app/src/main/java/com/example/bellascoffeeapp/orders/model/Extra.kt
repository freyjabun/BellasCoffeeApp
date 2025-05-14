package com.example.bellascoffeeapp.orders.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Extra(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Float,
    @SerialName("type")
    val type: String
)

@Serializable
data class ExtraDto(
    val name: String,
    val price: Float,
    val type: String
)


fun Extra.toDto(): ExtraDto{
    return ExtraDto(
        name = this.name,
        price = this.price,
        type = this.type
    )
}