package com.example.bellascoffeeapp.shop.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coffee(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Int,
    @SerialName("image_url")
    val imageUrl: String? = null,
    @SerialName("origin")
    val originCountry: String? = null,
    @SerialName("in_stock")
    val inStock: Boolean? = null,
)

data class CoffeeDto(
    val name: String,
    val price: Int,
    val imageUrl: String? = null,
    val originCountry: String? = null,
    val inStock: Boolean? = null
)

fun Coffee.toDto(): CoffeeDto {
    return CoffeeDto(
        name = this.name,
        price = this.price,
        imageUrl = this.imageUrl,
        originCountry = this.originCountry,
        inStock = this.inStock
    )
}
