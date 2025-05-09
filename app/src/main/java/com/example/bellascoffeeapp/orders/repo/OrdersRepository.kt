package com.example.bellascoffeeapp.orders.repo

import com.example.bellascoffeeapp.orders.model.DrinkDto
import com.example.bellascoffeeapp.orders.model.ExtraDto

interface OrdersRepository {
    suspend fun getDrinks() : List<DrinkDto>
    suspend fun getExtras(): List<ExtraDto>
}