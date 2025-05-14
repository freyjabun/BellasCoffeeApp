package com.example.bellascoffeeapp.orders.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Drink(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("image_url")
    val imageUrl: String? = null,
    @SerialName("s_price")
    val sPrice: Float? = null,
    @SerialName("m_price")
    val mPrice: Float? = null,
    @SerialName("l_price")
    val lPrice: Float ? = null,
    @SerialName("type")
    val type: String
)

@Serializable
data class DrinkDto(
    val name: String,
    val imageUrl: String? = null,
    val sPrice: Float? = null,
    val mPrice: Float? = null,
    val lPrice: Float? = null,
    val type: String
)

fun Drink.toDto(): DrinkDto{
    return DrinkDto(
        name = this.name,
        imageUrl = this.imageUrl,
        sPrice = this.sPrice,
        mPrice = this.mPrice,
        lPrice = this.lPrice,
        type = this.type
    )
}

