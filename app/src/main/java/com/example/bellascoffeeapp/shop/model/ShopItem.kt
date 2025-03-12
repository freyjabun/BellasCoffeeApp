package com.example.bellascoffeeapp.shop.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShopItemDTO(
    @SerialName("item_name")
    val name: String,
    @SerialName("item_price")
    val price: String,
    @SerialName("item_image")
    val imageUrl: String? = null,
    @SerialName("item_origin")
    val originCountry: String? = null,
    @SerialName("item_inStock")
    val inStock: Boolean? = null
)

data class ShopItem(
    val name: String,
    val price: String,
    val imageUrl: String? = null,
    val originCountry: String? = null,
    val inStock: Boolean? = null
)

fun ShopItemDTO.asDomainModel(): ShopItem {
    return ShopItem(
        name = this.name,
        price = this.price,
        imageUrl = this.imageUrl,
        originCountry = this.originCountry,
        inStock = this.inStock
    )
}