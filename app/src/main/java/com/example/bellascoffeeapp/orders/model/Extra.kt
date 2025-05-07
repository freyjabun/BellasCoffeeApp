package com.example.bellascoffeeapp.orders.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExtraDTO(
    @SerialName("extra_id")
    val id: Int,
    @SerialName("extra_name")
    val name: String,
    @SerialName("extra_type")
    val type: String,
    @SerialName("extra_price")
    val price: Int
)

@Serializable
data class Extra(
    val id: Int,
    val name: String,
    val type: String,
    val price: Int
)

@Serializable
data class OrderItemExtra(
    @SerialName("order_item_id")
    val orderItemId: Int,
    @SerialName("extra_id")
    val extraId: Int,
    val extra: ExtraDTO
)

fun ExtraDTO.toDomainModel(): Extra{
    return Extra(
        id = this.id,
        name = this.name,
        type = this.type,
        price = this.price
    )
}