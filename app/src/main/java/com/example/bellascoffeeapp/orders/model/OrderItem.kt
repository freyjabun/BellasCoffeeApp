package com.example.bellascoffeeapp.orders.model

import com.example.bellascoffeeapp.shop.model.ShopItem
import com.example.bellascoffeeapp.shop.model.ShopItemDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrderItemDTO(
    @SerialName("order_name")
    val name: String,
    @SerialName("order_price")
    val price: String,
    @SerialName("order_image")
    val imageUrl: String? = null
)

data class OrderItem(
    val name: String,
    val price: String,
    val imageUrl: String? = null
)

fun OrderItemDTO.asDomainModel(): OrderItem{
    return OrderItem(
        name = this.name,
        price = this.price,
        imageUrl = this.imageUrl
    )
}

