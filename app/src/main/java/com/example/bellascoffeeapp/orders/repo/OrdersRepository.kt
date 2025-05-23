package com.example.bellascoffeeapp.orders.repo

import com.example.bellascoffeeapp.orders.model.Category
import com.example.bellascoffeeapp.orders.model.Drink
import com.example.bellascoffeeapp.orders.model.ExtraDto

interface OrdersRepository {
    suspend fun getDrinks() : List<Drink>
    suspend fun getExtras(): List<ExtraDto>
    suspend fun getDrinksCategorised(): List<Category>
    suspend fun getDrinkById(id: String): List<Drink>
}