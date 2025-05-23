package com.example.bellascoffeeapp.orders.repo

import com.example.bellascoffeeapp.orders.model.Category
import com.example.bellascoffeeapp.orders.model.Drink
import com.example.bellascoffeeapp.orders.model.Extra
import com.example.bellascoffeeapp.orders.model.ExtraDto
import com.example.bellascoffeeapp.orders.model.toDto
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest

class OrdersRepositoryImpl(private val db: SupabaseClient) : OrdersRepository {

    override suspend fun getDrinks(): List<Drink> {
        return db.postgrest.from("drinks")
            .select().decodeList<Drink>()
    }

    override suspend fun getExtras(): List<ExtraDto> {
        val extras = db.postgrest.from("extras")
            .select().decodeList<Extra>()

        return extras.map { it.toDto() }
    }

    override suspend fun getDrinksCategorised(): List<Category>{
        val items = db.postgrest.from("drinks")
            .select().decodeList<Drink>()

        return items
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

    override suspend fun getDrinkById(id: String): List<Drink> {
        val item = db.postgrest.from("drinks").select {
            filter {
                eq("id", id)
            }
        }.decodeList<Drink>()

        return item
    }
}