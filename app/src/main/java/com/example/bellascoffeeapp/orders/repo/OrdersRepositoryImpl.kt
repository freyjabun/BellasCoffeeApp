package com.example.bellascoffeeapp.orders.repo

import com.example.bellascoffeeapp.orders.model.Category
import com.example.bellascoffeeapp.orders.model.Drink
import com.example.bellascoffeeapp.orders.model.DrinkDto
import com.example.bellascoffeeapp.orders.model.Extra
import com.example.bellascoffeeapp.orders.model.ExtraDto
import com.example.bellascoffeeapp.orders.model.toDto
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest

class OrdersRepositoryImpl(private val db: SupabaseClient) : OrdersRepository {

    override suspend fun getDrinks(): List<DrinkDto> {
        val items = db.postgrest.from("drinks")
            .select().decodeList<Drink>()

        return items.map { it.toDto() }
    }

    override suspend fun getExtras(): List<ExtraDto> {
        val extras = db.postgrest.from("extras")
            .select().decodeList<Extra>()

        return extras.map { it.toDto() }
    }

    override suspend fun getDrinksCategorised(): List<Category>{
        val items = db.postgrest.from("drinks")
            .select().decodeList<Drink>()

        return items.map { it.toDto() }

            .groupBy {
                it.type
            }.toMap()
            .map {
                Category(
                    name = it.key.toString(),
                    items = it.value
                )
            }
    }
}