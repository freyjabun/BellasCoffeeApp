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


